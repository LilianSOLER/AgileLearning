package oop.filesys.tests;

import oop.filesys.EOFException;
import oop.filesys.FSException;
import oop.filesys.IDirectory;
import oop.filesys.IFile;

public class TestSuite {

  static void ensure(boolean cond) {
    if (!cond)
      throw new AssertionError();
  }

  static void ensure(boolean cond, String msg) {
    if (!cond)
      throw new AssertionError(msg);
  }

  public static void test00(IDirectory root) throws FSException, EOFException {
    IDirectory dir;
    IDirectory home;
    IDirectory homex;
    IDirectory tmp;

    test00a(root);
    test00b(root);
    test00c(root);

    // let's create some directories
    //    /homex/
    //    /home
    //    /home/ogruber/
    homex = root.mkdir("homex");
    ensure(homex.parent() == root);
    ensure(homex.valid());

    home = root.mkdir("home");
    dir = home.mkdir("ogruber");

    // let's check we can't create a name conflict on directory
    try {
      home.mkdir("ogruber");
      ensure(false); // previous line should have thrown an FSException
    } catch (FSException ex) {
    }

    // let's check we can't create a name conflict on file
    try {
      home.touch("ogruber");
      ensure(false); // previous line should have thrown an FSException
    } catch (FSException ex) {
    }

    // let's create a file /home/ogruber/toto
    IFile file = dir.touch("toto");
    // can we find it?
    ensure(dir.file("toto") != null);
    
    // let's check we can't create a name conflict on directory
    try {
      dir.mkdir("toto");
      ensure(false); // previous line should have thrown an FSException
    } catch (FSException ex) {
    }

    // let's check we can't create a name conflict on file
    ensure(file==dir.touch("toto"));

    test00d(file);

    test00e(file);

    // let's remove the file /home/ogruber/toto
    // making sure it is parentless, once removed
    // and making sure it can no longer be found 
    // by name.
    ensure(dir.rm("toto"));
    checkRemoved(dir, file);

    // let's try directory renaming
    // let's rename /home/ogruber/
    // into /home/grubero/
    dir = home.dir("ogruber");
    ensure(dir.move(home, "grubero"));
    ensure(dir.parent() == home);
    tmp = home.dir("ogruber");
    ensure(tmp == null);
    tmp = home.dir("grubero");
    ensure(tmp == dir);

    // let's try moving a directory
    // /home/grubero/ -> /homex/ogruber/
    ensure(dir.move(homex, "ogruber"));
    ensure(dir.parent() == homex);
    tmp = home.dir("grubero");
    ensure(tmp == null);
    tmp = homex.dir("ogruber");
    ensure(tmp == dir);

    // let's create a conflict for the move.
    // so recreate /home/grubero and let's try
    // to move /homex/ogruber -> /home/grubero

    tmp = home.mkdir("grubero");
    ensure(!dir.move(home, "grubero"));

    // and then let's try a move without changing the name
    // to move /homex/ogruber -> /home/ogruber
    ensure(dir.move(home, "ogruber"));
    ensure(dir.parent() == home);
    ensure(dir == home.dir("ogruber"));

    home.rmdir(dir.name());
    checkRemoved(home, dir);
    home.rmdir(tmp.name());
    checkRemoved(home, tmp);
        
    // let's try to move a file.
    IDirectory src,dst;
    src = home.mkdir("src");
    dst = home.mkdir("dst");
    file = src.touch("toto");
    ensure(file.move(dst, "tata"));
    ensure(file.parent() == dst);
    
    file = src.touch("tata");
    ensure(!file.move(dst, "tata"));
    ensure(file.parent() == src);
    ensure(file.move(dst, "toto"));
    ensure(file.parent() == dst);
    
    ensure(dst.rm("toto"));
    ensure(dst.rm("tata"));
    ensure(home.rmdir("src"));
    ensure(home.rmdir("dst"));
  }

  /*
   * Testing:
   *    - directory creation 
   *    - directory removal by name
   */
  private static void test00a(IDirectory root) throws FSException {
    IDirectory dir, tmp;
    // let's create directory /boot/
    dir = root.mkdir("boot");

    // let's make sure we see the directory /boot/
    tmp = root.dir("boot");
    ensure(dir == tmp);

    // let's try directory removal
    // making sure the removed directory is parentless
    ensure(root.rmdir("boot"));
    checkRemoved(root, tmp);
  }

  /*
   * Testing:
   *    - directory creation 
   *    - directory removal
   */
  private static void test00b(IDirectory root) throws FSException {
    IDirectory dir, tmp;
    // let's create directory /boot/
    dir = root.mkdir("boot");

    // let's make sure we see the directory /boot/
    tmp = root.dir("boot");
    ensure(dir == tmp);

    // let's try directory removal
    root.rmdir(tmp.name());
    checkRemoved(root, tmp);
  }

  /*
   * Testing:
   *    - directory creation 
   *    - directory removal failure when not empty
   */
  private static void test00c(IDirectory root) throws FSException {
    IDirectory dir, tmp;
    // let's create directory /boot/
    dir = root.mkdir("boot");

    // let's make sure we see the directory /boot/
    tmp = root.dir("boot");
    ensure(dir == tmp);

    IFile file = dir.touch("toto");
    ensure(file != null);

    // let's try directory removal
    // it must fail since the directory is not empty.
    try {
      root.rmdir("boot");
    } catch (Throwable th) {
      ensure(false);
    }

    ensure(dir.rm("toto"));
    checkRemoved(dir, file);

    // retry the removal, now that it is empty.
    tmp.parent().rmdir(tmp.name());
    checkRemoved(root, tmp);
  }

  /*
   * Testing writing and reading a file
   */
  private static void test00d(IFile file) throws FSException, EOFException {
    // let's write some data into the file
    // we just created
    for (int i = -128; i <= 127; i++)
      file.write((byte) i);

    // now let's re-read that data
    file.seek(0);
    for (int i = -128; i <= 127; i++) {
      byte val = file.read();
      ensure(((byte) i) == val);
    }
    // let's read it again, but from the end
    // of the file, using the seek method
    for (int i = 127; i >= -128; i--) {
      file.seek(i + 128);
      byte val = file.read();
      ensure(((byte) i) == val);
    }

  }

  /*
   * Testing writing and reading a file
   */
  private static void test00e(IFile file) throws FSException, EOFException {
    // let's write a lot of data into the file
    file.seek(0);
    for (int i = 0; i < 4096; i++)
      file.write((byte) i);

    // now let's re-read that data
    file.seek(0);
    for (int i = 0; i < 4096; i++) {
      byte val = file.read();
      ensure(((byte) i) == val);
    }
    // let's read it again, but from the end
    // of the file, using the seek method
    for (int i = 4096-1; i >= 0; i--) {
      file.seek(i);
      byte val = file.read();
      ensure(((byte) i) == val);
    }

  }

  /*
   * Verifies that a directory is removed.
   * Notice that the child is not disconnected from its parent, 
   * while the parent no longer references the child.
   * Overall, the methods allowing to know which child it is are still 
   * functional, but any method manipulating the child will throw an 
   * illegal state exception.
   * @param parent
   * @param child
   * @throws FSException
   */
  static void checkRemoved(IDirectory parent, IDirectory child) throws FSException {
    ensure(!child.valid());
    try {
      ensure(parent.getFileSystem() == child.getFileSystem());
      ensure(parent == child.parent());
      child.name();
      child.path();
    } catch (Throwable th) {
      ensure(false);
    }
    ensure(null == parent.dir(child.name()));
    try {
      child.move(parent, "pouet");
      ensure(false);
    } catch (FSException ex) {
    }
    try {
      child.dir("pouet");
      ensure(false);
    } catch (FSException ex) {
    }
    try {
      child.dirs();
      ensure(false);
    } catch (FSException ex) {
    }
    try {
      child.file("pouet");
      ensure(false);
    } catch (FSException ex) {
    }
    try {
      child.files();
      ensure(false);
    } catch (FSException ex) {
    }
    try {
      child.mkdir("pouet");
      ensure(false);
    } catch (FSException ex) {
    }
    try {
      child.rmdir("pouet");
      ensure(false);
    } catch (FSException ex) {
    }
    try {
      child.touch("pouet");
      ensure(false);
    } catch (FSException ex) {
    }
    try {
      child.rm("pouet");
      ensure(false);
    } catch (FSException ex) {
    }
  }

  /*
   * Verifies that a file is removed.
   * Notice that the file is not disconnected from its directory, 
   * while the directory no longer references the file.
   * Overall, the methods allowing to know which file it is are still 
   * functional, but any method manipulating the file will throw an 
   * illegal state exception.
   * @param directory 
   * @param file
   * @throws FSException
   */
  static void checkRemoved(IDirectory dir, IFile file) throws FSException {
    ensure(!file.valid());
    try {
      ensure(dir == file.parent());
      file.name();
      file.path();
    } catch (Throwable th) {
      ensure(false);
    }
    ensure(null == dir.file(file.name()));
    try {
      file.move(dir, "pouet");
      ensure(false);
    } catch (FSException ex) {
    }
    try {
      file.size();
      ensure(false);
    } catch (FSException ex) {
    }
    try {
      file.available();
      ensure(false);
    } catch (FSException ex) {
    }
    try {
      file.read();
      ensure(false);
    } catch (EOFException ex) {
      ensure(false);
    } catch (FSException ex) {
    }
    try {
      file.write((byte) 0);
      ensure(false);
    } catch (FSException ex) {
    }
    try {
      file.seek(0);
      ensure(false);
    } catch (FSException ex) {
    }
  }

}
