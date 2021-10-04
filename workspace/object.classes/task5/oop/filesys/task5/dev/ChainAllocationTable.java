package oop.filesys.task5.dev;

import java.io.IOException;

/**
 * Block Allocation Table
 * It is an allocator for chains of blocks (lists), 
 * inspired by the FAT format for disk.
 * It applies to block device of a fixed size,
 * in terms of a fixed number of blocks,
 * each block having the same fixed length.
 * 
 * When formatted, the block allocation table
 * is created on the first blocks (nReservedBlocks).
 * It is essentially an array of integer values.
 * Each entry may have four possible values:
 * 
 *   - RESERVED_BLOCK: indicates the corresponding block is reserved.
 *   - FREE_BLOCK: indicates the corresponding block is free.
 *   - EOF_BLOCK:  indicates the corresponding block is the last 
 *                 in its chain of blocks.
 *   - a block number: the number of the next block in the chain.
 * 
 * Example: with a device of only 8-blocks
 *          there is one reserved block (block-0)
 *          the table, stored in the reserved block, looks like this:
 *                  
 *    0   1   2   3   4   5   6   7     
 *    -3  -2  -2  -2  -2  -2  -2  -2
 * 
 * The first line gives you the index in the table,
 * the second line gives you the values in the entries of the table.
 * You see that block-0 is reserved (RESERVED_BLOCK=-3).
 * You see that all other blocks are free (FREE_BLOCK=-2)
 * 
 * After a first allocation, that allocates the block-1 
 *        BlockAllocationTable bat;
 *        int bn = bat.allocate(EOF_BLOCK);
 *        
 *    0   1   2   3   4   5   6   7     
 *    -3  -1  -2  -2  -2  -2  -2  -2
 *    
 * You see that block-0 is still reserved (RESERVED_BLOCK=-3).
 * You see that block-1 is allocated and last in its chain (EOF_BLOCK=-1)
 * You see that all other blocks are free (FREE_BLOCK=-2)
 *    
 * After a second allocation, that allocates the block-2 
 *        BlockAllocationTable bat;
 *        int bn = bat.allocate(1);
 *        
 *    0   1   2   3   4   5   6   7     
 *    -3   2  -1  -2  -2  -2  -2  -2
 *    
 * You see that block-0 is still reserved (RESERVED_BLOCK=-3).
 * You see that block-1 is allocated and the next block is block-2.
 * You see that block-2 is last in its chain (EOF_BLOCK=-1)
 * You see that all other blocks are free (FREE_BLOCK=-2)
 * 
 * After a third allocation, that allocates the block-2 
 *        BlockAllocationTable bat;
 *        int bn = bat.allocate(2);
 *    
 *    0   1   2   3   4   5   6   7     
 *    -3   2   3  -1  -2  -2  -2  -2
 *    
 * You see that block-0 is still reserved (RESERVED_BLOCK=-3).
 * You see that block-1 is allocated and the next block is block-2.
 * You see that block-2 is allocated and the next block is block-3.
 * You see that block-3 is last in its chain (EOF_BLOCK=-1)
 * You see that all other blocks are free (FREE_BLOCK=-2)
 * 
 * It is of course to start another chain of blocks
 *        int bn = bat.allocate(EOF_BLOCK);
 *        bn = bat.allocate(bn);
 *        
 *    0   1   2   3   4   5   6   7     
 *    -3   2   3  -1  5  -1  -2  -2
 * 
 * One chain starts at block-1 and contains 3 blocks.
 * The other chain starts at block 4 and contains 2 blocks.
 * 
 * @author Pr. Olivier Gruber
 */
public class ChainAllocationTable {

  private static final int ENTRY_SIZE = 4;

  private static final int RESERVED_BLOCK = -3;
  private static final int FREE_BLOCK = -2;
  public  static final int EOF_BLOCK = -1;

  private BlockDevice m_device;
  private int m_nReservedBlocks;
  private int m_nEntriesPerBlock;
  private byte[] m_buffer;
  
  public ChainAllocationTable(BlockDevice cache) throws IOException {
    m_device = cache;
    int blockSize = m_device.getBlockSize();
    int blockCount = m_device.getBlockCount();
    m_buffer = new byte[blockSize];
    m_nEntriesPerBlock = blockSize / ENTRY_SIZE;
    m_nReservedBlocks = ENTRY_SIZE * blockCount / blockSize;
    if (m_nReservedBlocks * blockSize / ENTRY_SIZE < blockCount)
      m_nReservedBlocks++;
  }

  public BlockDevice getDevice() {
    return m_device;
  }

  /**
   * Format the block device, creating a brand new 
   * block allocation table in the first reserved blocks
   * (nReservedBlocks). 
   * The reserved blocks are marked as EOF_BLOCK, all
   * the other blocks are marked as FREE_BLOCK.
   * @throws IOException
   */
  public void format() throws IOException {
    int bSize = m_device.getBlockSize();
    int bn = 0;
    for (int n = 0; n < m_nReservedBlocks; n++) {
      for (int offset = 0; offset < bSize; offset += ENTRY_SIZE,bn++)
        if (bn < m_nReservedBlocks)
          setInt32(m_buffer, offset, RESERVED_BLOCK);
        else
          setInt32(m_buffer, offset, FREE_BLOCK);
      m_device.write(n, m_buffer);
    }
  }
  
  /**
   * Returns the head of the block chain, if at least
   * one was created. You can know that if the returned
   * block is also allocated (see isAllocated(int)).
   * @return
   */
  public int getRoot() {
    return m_nReservedBlocks;
  }

  /*
   * Tells if a given is allocated or not. 
   * If not allocated, it could be free or it could reserved.
   */
  public boolean isAllocated(int prev) throws IOException {
    int batbn = prev / m_nEntriesPerBlock;
    m_device.read(batbn, m_buffer);
    int offset = ENTRY_SIZE * (prev - batbn * m_nEntriesPerBlock);
    int bn = getInt32(m_buffer, offset);
    return (bn != FREE_BLOCK);
  }
  
  /*
   * @return the next block of the given block or EOF_BLOCK
   *         if the given block was the last of a block chain.
   */
  public int getNextBlock(int prev) throws IOException {
    int batbn = prev / m_nEntriesPerBlock;
    m_device.read(batbn, m_buffer);
    int offset = ENTRY_SIZE * (prev - batbn * m_nEntriesPerBlock);
    int bn = getInt32(m_buffer, offset);
    if (bn < EOF_BLOCK)
      throw new Error("PANIC: clobered list: prev="+prev+" next="+bn);
    return bn;
  }


  public int allocate(int last) throws IOException {
    int bSize = m_device.getBlockSize();
    int bCount = m_device.getBlockCount();
    int bn=0;
    for (int batbn=0; bn<bCount && batbn < m_nReservedBlocks; batbn++) {
      m_device.read(batbn, m_buffer);
      for (int offset = 0; offset < bSize && bn<bCount; offset += ENTRY_SIZE,bn++) {
        int val = getInt32(m_buffer, offset);
        if (val == FREE_BLOCK) {
          if (last != EOF_BLOCK)
            setNext(last, bn);
          setInt32(m_buffer,offset,EOF_BLOCK);
          m_device.write(batbn,m_buffer);
          return bn;
        }
      }
    }
    return EOF_BLOCK;
  }
  
  /**
   * Deallocate all the blocks of a chain, the given 
   * block must therefore be the head of the chain 
   * of blocks.
   * @param head
   * @throws IOException
   */
  public void deallocate(int head) throws IOException {
    while (head != EOF_BLOCK) {
      int next = getNextBlock(head);
      free(head);
      head = next;
    }
  }

  /**
   * Prune a chain after the given block, deallocating
   * any block chained after the given block.
   * @param tail
   * @throws IOException
   */
  public void prune(int tail) throws IOException {
    int head = getNextBlock(tail);
    setNext(tail, EOF_BLOCK);
    deallocate(head);
  }

  /**
   * Chains the two given blocks.
   * @param prev
   * @param next
   * @throws IOException
   */
  private void setNext(int prev, int next) throws IOException {
    int batbn = prev / m_nEntriesPerBlock;
    m_device.read(batbn, m_buffer);
    int offset = ENTRY_SIZE * (prev - batbn * m_nEntriesPerBlock);
    int val = getInt32(m_buffer, offset);
    if (val == FREE_BLOCK)
      throw new Error("PANIC: clobered list: prev="+prev+" next="+next);
    setInt32(m_buffer, offset, next);
    m_device.write(batbn,m_buffer);
  }

  /**
   * Mark the given block as free. 
   * WARNING: never call directly, this method does not know about chains,
   *          it forces the given block as a free block.
   * @param bn
   * @throws IOException
   */
  private void free(int bn) throws IOException {
    int batbn = bn / m_nEntriesPerBlock;
    m_device.read(batbn, m_buffer);
    int offset = ENTRY_SIZE * (bn - batbn * m_nEntriesPerBlock);
    int val = getInt32(m_buffer, offset);
    if (val < EOF_BLOCK)
      throw new Error("PANIC: clobered list");
    setInt32(m_buffer, offset, FREE_BLOCK);
    m_device.write(batbn,m_buffer);
  }

  /**
   * Gets a 32-bit signed integer from the given byte array at the given offset.
   *
   * @param src
   * @param offset
   */
  public static int getInt32(byte[] src, int offset) {
    final int v0 = src[offset + 0] & 0xFF;
    final int v1 = src[offset + 1] & 0xFF;
    final int v2 = src[offset + 2] & 0xFF;
    final int v3 = src[offset + 3] & 0xFF;
    return ((v3 << 24) | (v2 << 16) | (v1 << 8) | v0);
  }

  /**
   * Sets a 32-bit integer in the given byte array at the given offset.
   */
  public static void setInt32(byte[] dst, int offset, int value) {
    dst[offset + 0] = (byte) (value & 0xFF);
    dst[offset + 1] = (byte) ((value >>> 8) & 0xFF);
    dst[offset + 2] = (byte) ((value >>> 16) & 0xFF);
    dst[offset + 3] = (byte) ((value >>> 24) & 0xFF);
  }

}
