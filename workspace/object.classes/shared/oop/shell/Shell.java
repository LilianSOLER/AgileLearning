/*
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Created on: November, 2017
 *      Author: Pr. Olivier Gruber <olivier dot gruber at acm dot org>
 */
package oop.shell;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import oop.filesys.EOFException;
import oop.filesys.FSException;
import oop.filesys.IDirectory;
import oop.filesys.IFile;
import oop.filesys.IFileSystem;

public class Shell {

  PrintStream ps;
  BufferedReader br;
  String username;
  IFileSystem fs;
  IDirectory root;
  IDirectory wd;

  public Shell(PrintStream ps, InputStream is, IFileSystem fs) {
    this.br = new BufferedReader(new InputStreamReader(is));
    this.fs = fs;
    this.root = fs.root();
    this.wd = root;
    this.ps = ps;
  }

  public void loop() throws java.io.IOException, FSException {
    while (true) {
      ps.print("> ");
      ps.flush();
      String line = br.readLine();
      String words[] = parseLine(line);
      try {
        interpret(words);
      } catch (Throwable th) {
      }
    }
  }

  private String[] parseLine(String line) {
    String words[] = new String[16];
    int nwords = 0;
    int idx = line.indexOf(' ');
    while (idx != -1) {
      String word = line.substring(0, idx);
      word = word.trim();
      words[nwords++] = word;
      line = line.substring(idx + 1);
      idx = line.indexOf(' ');
    }
    words[nwords++] = line.trim();
    String tmp[] = new String[nwords];
    System.arraycopy(words, 0, tmp, 0, nwords);
    return tmp;
  }

  private void help(String args[]) {
    if (args == null || args.length == 0) {
      ps.println("Commands: pwd, cd, ls, mkdir, rmdir, touch, edit, cat, mv, sync, exit");
      ps.println("Specific help:  help command");

    } else {
      String cmd = args[0];
      if (cmd.equals("pwd")) {
        ps.println(" pwd: print current directory");
      } else if (cmd.equals("sync")) {
        ps.println(" sync: write all changes to mass storage");
      } else if (cmd.equals("exit")) {
        ps.println(" exit: sync and exit");
      } else if (cmd.equals("cd")) {
        ps.println(" cd: change current directory");
      } else if (cmd.equals("ls")) {
        ps.println(" ls: list the contents of a directory, given as a path");
      } else if (cmd.equals("mkdir")) {
        ps.println(" mkdir: makes a directory, given as a path");
      } else if (cmd.equals("rmdir")) {
        ps.println(" rmdir: removes a directory, given as a path");
      } else if (cmd.equals("touch")) {
        ps.println(" touch: creates an empty file, given as a path");
      } else if (cmd.equals("rm")) {
        ps.println(" rm: removes a file, given as a path");
      } else if (cmd.equals("edit")) {
        ps.println(" edit: allows to append lines of text to a file");
      } else if (cmd.equals("cat")) {
        ps.println(" cat: prints the contents of a file, given as a path");
      } else if (cmd.equals("mv")) {
        ps.println(" mv: moves a directory or a file to the given name in the current directory");
        ps.println("    ln path name");
      }
    }
  }

  private void interpret(String words[]) throws FSException, EOFException {
    String[] args = null;
    if (words.length > 1) {
      args = new String[words.length - 1];
      System.arraycopy(words, 1, args, 0, args.length);
    }
    String cmd = words[0];
    if (cmd.equals("help")) {
      help(args);
    } else if (cmd.equals("exit")) {
      fs.sync();
      System.exit(0);
    } else if (cmd.equals("sync")) {
      fs.sync();
    } else if (cmd.equals("pwd")) {
      ps.println(wd);
    } else if (cmd.equals("cd")) {
      cd(args);
    } else if (cmd.equals("ls")) {
      ls(args);
    } else if (cmd.equals("mkdir")) {
      mkdir(args);
    } else if (cmd.equals("rmdir")) {
      rmdir(args);
    } else if (cmd.equals("touch")) {
      touch(args);
    } else if (cmd.equals("rm")) {
      rm(args);
    } else if (cmd.equals("edit")) {
      edit(args);
    } else if (cmd.equals("cat")) {
      cat(args);
    } else if (cmd.equals("mv")) {
      mv(args);
    } else
      fail("Unknown command: " + cmd);
  }

  private void fail(String message) throws FSException {
    ps.println(message);
    throw new FSException(message);
  }

  /*
   * Translates a name to a directory (must be a directory, not a file), 
   * relative to the given directory.
   * @param: create, forces the creation of the directory if set to true.
   * @throw FSException if the path is not a valid path to a directory.
   */
  private IDirectory nameToDir(IDirectory d, String name, boolean create) throws FSException {
    name = name.trim();
    if (name.length() == 0)
      return d;
    if (name.equals("."))
      return d;
    if (name.equals("..")) {
      if (d != root)
        d = d.parent();
    } else {
      IDirectory t;
      t = d.dir(name);
      if (t == null) {
        if (create) {
          t = d.mkdir(name);
        } else
          fail("  -- missing " + name + " in path " + d.path());
      }
      d = t;
    }
    return d;
  }

  /*
   * Translates a path to a directory (must be a directory, not a file).
   * @param: create, forces the creation of the directory if set to true.
   * @throw FSException if the path is not a valid path to a directory.
   */
  private IDirectory pathToDir(String path, boolean create) throws FSException {
    IDirectory d = wd;
    if (path.startsWith("/")) {
      d = root;
      path = path.substring(1);
    }
    int idx = path.indexOf('/');
    while (idx != -1) {
      String name = path.substring(0, idx);
      d = nameToDir(d, name, create);
      path = path.substring(idx + 1);
      idx = path.indexOf('/');
    }
    if (path.length() != 0)
      d = nameToDir(d, path, create);
    return d;
  }

  /*
   * Translates a path to a file (must be a file, not a directory).
   * @throw FSException if the path is not a valid path to a file.
   */
  private IFile pathToFile(String path, boolean create) throws FSException {
    IDirectory d = wd;
    if (path.startsWith("/")) {
      d = root;
      path = path.substring(1);
    }
    int idx = path.indexOf('/');
    while (idx != -1) {
      String name = path.substring(0, idx);
      d = nameToDir(d, name, create);
      path = path.substring(idx + 1);
      idx = path.indexOf('/');
    }
    if (path.length() == 0)
      fail("  -- not a file path");
    IFile f = d.file(path);
    if (f == null)
      f = d.touch(path);
    return f;
  }

  /**
   * Change the current directory to the given path
   * @param args
   * @throws FSException
   */
  private void cd(String args[]) throws FSException {
    if (args == null || args.length < 1)
      fail("  -- missing path");
    wd = pathToDir(args[0], false);
  }

  /**
   * Makes a directory, given a path
   * @param args
   * @throws FSException
   */
  private void mkdir(String args[]) throws FSException {
    if (args == null || args.length < 1)
      fail("  -- missing path");
    pathToDir(args[0], true);
  }

  /**
   * Removes a directory, given a path
   * @param args
   * @throws FSException
   */
  private void rmdir(String args[]) throws FSException {
    IDirectory d;
    if (args == null || args.length < 1)
      fail("  -- missing path");
    d = pathToDir(args[0], false);
    IDirectory p = d.parent();
    p.rmdir(d.name());
  }

  /**
   * List the contents of a directory given as a path
   * @param args
   * @throws FSException
   */
  private void ls(String args[]) throws FSException {
    IDirectory d = wd;
    if (args != null && args.length > 0) {
      String path = args[0];
      d = pathToDir(path, false);
    }
    IDirectory[] dirs = d.dirs();
    for (int i = 0; i < dirs.length; i++) {
      String name = dirs[i].name();
      ps.println(name);
    }
    int max = 8;
    IFile[] files = d.files();
    for (int i = 0; i < files.length; i++) {
      String name = files[i].name();
      int size = files[i].size();
      String ss = Integer.toString(size);
      int len = ss.length();
      if (max < len)
        max = len;
      ps.print(ss);
      for (int j = len; j < max; j++)
        ps.print(" ");
      ps.println(name);
    }
  }

  /**
   * Creates a file given its path.
   * @param args
   * @throws FSException
   */
  private void touch(String args[]) throws FSException {
    if (args == null || args.length < 1)
      fail("  -- missing path");
    String path = args[0];
    IFile f = pathToFile(path, true);
    if (f == null)
      fail("  -- failed creation for " + path);
  }

  /**
   * Remove a file, given a path.
   * @param args
   * @throws FSException
   */
  private void rm(String args[]) throws FSException {
    if (args == null || args.length < 1)
      fail("  -- missing path");
    IDirectory d = wd;
    String path = args[0];
    IFile f = pathToFile(path, false);
    if (f != null) {
      d = f.parent();
      d.rm(f.name());
    } else
      fail("  -- missing file:" + path);
  }

  /**
   * Prints the content of a file.
   * @param args
   * @throws FSException
   */
  private void cat(String args[]) throws FSException, EOFException {
    if (args == null || args.length < 1)
      fail("  -- missing path");
    IDirectory d = wd;
    String path = args[0];
    IFile file = pathToFile(path, false);
    if (file != null) {
      file.seek(0);
      while (file.available() != 0)
        ps.print((char) file.read());
    } else
      fail("Not found:" + path);
  }

  /**
   * Allows to edit a file, entering text.
   * There is no real editing capabilities here, just the ability 
   * to add new lines.
   */
  private void edit(String args[]) throws FSException {
    if (args == null || args.length < 1)
      fail("  -- missing path");
    IDirectory d = wd;
    String path = args[0];
    IFile file = pathToFile(path, false);
    if (file != null) {
      System.out.println("Appending to file: " + path);
      System.out.println("  - enter lines of text below...");
      System.out.println("  - end with an empty line.");
      System.out.flush();
      try {
        file.seek(file.size());

        String line = br.readLine();
        while (line.length() != 0) {
          char chars[] = line.toCharArray();
          for (int i = 0; i < chars.length; i++)
            file.write((byte) chars[i]);
          file.write((byte) '\n');
          line = br.readLine();
        }
      } catch (java.io.IOException ex) {
        throw new FSException(ex);
      }
    } else
      fail("Not found:" + path);
  }

  /*
   * Parses a path to the corresponding directory or file.
   */
  private Object parsePath(String path) throws FSException {
    // let's parse the linked path:
    IDirectory d = wd;
    if (path.startsWith("/")) {
      d = root;
      path = path.substring(1);
    }
    int idx = path.indexOf('/');
    while (idx != -1) {
      String name = path.substring(0, idx);
      d = nameToDir(d, name, false);
      path = path.substring(idx + 1);
      idx = path.indexOf('/');
    }
    IFile f = null;
    if (path.length() != 0) {
      f = d.file(path);
      if (f != null)
        return f;
      d = d.dir(path);
      if (d == null)
        fail("  --missing path");
      return d;
    }
    return d;
  }

  /*
   * Moves a resource given as a path to a local name.
   *  mv path name
   *  
   * So the first argument is a path, any path, relative or absolute.
   * The second argument is a name, not a path (no '/' character).
   * @throws FSException if the path does not exist
   */
  private void mv(String args[]) throws FSException {
    Object n = parsePath(args[0]);
    String name = args[1];
    if (name.indexOf('/') != -1)
      throw new IllegalArgumentException("No path as a link name");

    if (n instanceof IDirectory) {
      IDirectory dir = (IDirectory) n;
      if (!dir.move(wd, name))
        fail("  --move refused: name conflict");
    } else if (n instanceof IFile) {
      IFile file = (IFile) n;
      if (!file.move(wd, name))
        fail("  --move refused: name conflict");
    } else
      fail("  --panic: internal error");

  }

}
