package oop.filesys.task5.dev;

import java.io.File;
import java.io.IOException;

public class Tests {

  private static final int EOF_BLOCK = -1;

  static void ensure(boolean cond, String msg) {
    if (!cond) {
      System.out.println("FAILED:" + msg);
      throw new Error(msg);
    }
  }

  public static void main(String[] args) throws IOException {
    Tests tests = new Tests();
    tests.test0();
    tests.test1();
    tests.test2();
    System.out.println("PASSED");
  }

  BlockDevice m_dev;
  ChainAllocationTable m_bat;

  public Tests() throws IOException {
    File file = new File("disk.img");
    m_dev = new BlockDevice(file, 512, 64);
    m_bat = new ChainAllocationTable(m_dev);
    m_bat.format();
  }

  void test0() throws IOException {
    int bn;
    bn = m_bat.allocate(EOF_BLOCK);
    m_bat.deallocate(bn);
  }

  void test1() throws IOException {
    int b1, b2, b3;
    b1 = m_bat.allocate(EOF_BLOCK);
    b2 = m_bat.allocate(b1);
    b3 = m_bat.allocate(b2);

    ensure(b2 == m_bat.getNextBlock(b1), "");
    ensure(b3 == m_bat.getNextBlock(b2), "");
    ensure(EOF_BLOCK == m_bat.getNextBlock(b3), "");

    m_bat.deallocate(b1);
    ensure(!m_bat.isAllocated(b3), "");
    ensure(!m_bat.isAllocated(b2), "");
    ensure(!m_bat.isAllocated(b1), "");
  }

  void test2() throws IOException {
    int b1, b2, b3;
    b1 = m_bat.allocate(EOF_BLOCK);
    b2 = m_bat.allocate(b1);
    b3 = m_bat.allocate(b2);

    ensure(b2 == m_bat.getNextBlock(b1), "");
    ensure(b3 == m_bat.getNextBlock(b2), "");
    ensure(EOF_BLOCK == m_bat.getNextBlock(b3), "");

    m_bat.prune(b2);
    ensure(!m_bat.isAllocated(b3), "");
    ensure(b2 == m_bat.getNextBlock(b1), "");
    ensure(EOF_BLOCK == m_bat.getNextBlock(b2), "");

    m_bat.prune(b1);
    ensure(!m_bat.isAllocated(b2), "");
    ensure(EOF_BLOCK == m_bat.getNextBlock(b1), "");

    m_bat.deallocate(b1);
    ensure(!m_bat.isAllocated(b1), "");

  }

}
