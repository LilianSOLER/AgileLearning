package oop.filesys.task5.fs;

import edu.polytech.oop.collections.ICollection.Iterator;
import oop.filesys.FSException;
import oop.filesys.IDirectory;
import oop.filesys.IFile;
import oop.filesys.task4.Node;

public class Directory extends oop.filesys.task4.Directory {
  FileSystem m_fs;

  public Directory(FileSystem fs) throws FSException {
    super(fs);
    m_fs = fs;
    throw new RuntimeException("Not Yet Implemented");
  }

  public Directory(FileSystem fs, int headBlock) throws FSException {
    super(fs);
    m_fs = fs;
    throw new RuntimeException("Not Yet Implemented");
  }

  public Directory(Directory parent, String name) throws FSException {
    super(parent, name);
    m_fs = parent.m_fs;
    throw new RuntimeException("Not Yet Implemented");
  }

  /**
   * Synchronizes this directory with the data saved 
   * on the block device. This means saving the list
   * of nodes and enough information about those nodes
   * to be able to reconstruct this directory object
   * from the saved data.
   * Nota Bene: this may or may not sync the contents
   *            of the files in this directory, it will
   *            depend on how you implemented your files.
   * 
   * @throws FSException
   */
  void sync() throws FSException {
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public void add(Node child) throws FSException {
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public void remove(Node child) throws FSException {
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  protected Iterator iterator() {
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public void removed() throws FSException {
    throw new RuntimeException("Not Yet Implemented");
  }

  /*============================================================
   * YOU SHOULD BE ABLE TO REMOVE ALL METHODS BELOW
   * If you get compiler errors, such as the compiler asking
   * you to implement missing methods required by IDirectory,
   * you should revisit your design, it seems that the
   * super class ricm3.filesys.oop.Directory does not do enough.
   =============================================================*/

  @Override
  public boolean valid() {
    // REMOVE THIS METHOD.
    // If you have to have an implementation here, 
    // you should revisit your design, it seems that the
    // super class ricm3.filesys.oop.Directory does not do enough.
    throw new RuntimeException("SHOULD NOT BE IMPLEMENTED HERE");
  }

  @Override
  public IDirectory dir(String name) throws FSException {
    // REMOVE THIS METHOD.
    // If you have to have an implementation here, 
    // you should revisit your design, it seems that the
    // super class ricm3.filesys.oop.Directory does not do enough.
    throw new RuntimeException("SHOULD NOT BE IMPLEMENTED HERE");
  }

  @Override
  public IDirectory[] dirs() throws FSException {
    // REMOVE THIS METHOD.
    // If you have to have an implementation here, 
    // you should revisit your design, it seems that the
    // super class ricm3.filesys.oop.Directory does not do enough.
    throw new RuntimeException("SHOULD NOT BE IMPLEMENTED HERE");
  }

  @Override
  public IFile file(String name) throws FSException {
    // REMOVE THIS METHOD.
    // If you have to have an implementation here, 
    // you should revisit your design, it seems that the
    // super class ricm3.filesys.oop.Directory does not do enough.
    throw new RuntimeException("SHOULD NOT BE IMPLEMENTED HERE");
  }

  @Override
  public IFile[] files() throws FSException {
    // REMOVE THIS METHOD.
    // If you have to have an implementation here, 
    // you should revisit your design, it seems that the
    // super class ricm3.filesys.oop.Directory does not do enough.
    throw new RuntimeException("SHOULD NOT BE IMPLEMENTED HERE");
  }

  @Override
  public IDirectory mkdir(String name) throws FSException {
    // REMOVE THIS METHOD.
    // If you have to have an implementation here, 
    // you should revisit your design, it seems that the
    // super class ricm3.filesys.oop.Directory does not do enough.
    throw new RuntimeException("SHOULD NOT BE IMPLEMENTED HERE");
  }

  @Override
  public boolean rmdir(String name) throws FSException {
    // REMOVE THIS METHOD.
    // If you have to have an implementation here, 
    // you should revisit your design, it seems that the
    // super class ricm3.filesys.oop.Directory does not do enough.
    throw new RuntimeException("SHOULD NOT BE IMPLEMENTED HERE");
  }

  @Override
  public IFile touch(String name) throws FSException {
    // REMOVE THIS METHOD.
    // If you have to have an implementation here, 
    // you should revisit your design, it seems that the
    // super class ricm3.filesys.oop.Directory does not do enough.
    throw new RuntimeException("SHOULD NOT BE IMPLEMENTED HERE");
  }

  @Override
  public boolean rm(String name) throws FSException {
    // REMOVE THIS METHOD.
    // If you have to have an implementation here, 
    // you should revisit your design, it seems that the
    // super class ricm3.filesys.oop.Directory does not do enough.
    throw new RuntimeException("SHOULD NOT BE IMPLEMENTED HERE");
  }

}
