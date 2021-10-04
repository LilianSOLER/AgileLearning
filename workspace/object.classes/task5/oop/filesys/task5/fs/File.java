package oop.filesys.task5.fs;

import oop.filesys.EOFException;
import oop.filesys.FSException;

public class File extends oop.filesys.task4.File {

  FileSystem m_fs;

  public File(Directory parent, String name) throws FSException {
    super(parent, name);
    m_fs = parent.m_fs;
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public void removed() throws FSException {
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public int size() {
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public int available() {
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public byte read() throws FSException, EOFException {
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public void write(byte val) throws FSException {
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public void seek(int offset) throws FSException {
    throw new RuntimeException("Not Yet Implemented");
  }

  @Override
  public boolean valid() {
    // REMOVE THIS METHOD.
    // If you have to have an implementation here, 
    // you should revisit your design, it seems that the
    // super class ricm3.filesys.oop.File does not do enough.
    throw new RuntimeException("SHOULD NOT BE IMPLEMENTED HERE");
  }
  
}
