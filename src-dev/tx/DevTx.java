package tx;


public class DevTx
{
    // TDB 0.8.10 is rev 8718; TxTDB forked at 8731
    
    // BPTreeRecords and BPTreeNode need have a common supertype - can it be an interface?
    //   Then BPTreeRecords inherits from RecordBufferPage
    
    // Check through BPLusNode/BPTreeRecords hierarchy.
    // Check through BPlusNodeMgr/BPTreeRecordsMgr hierarchy.
    // Currently BPTreeRecordsMgr wraps a RecordBufferPageMgr -- does it matter?
    
    // Can we:
    //   BPTreeRecords extends RecordBufferPage (it only adds functionality)
    //   BPTreeRecordsMgr extends extends PageBlockMgr<BPTreeRecords> 
    //   BPTreeNodeMgr extends PageBlockMgr<BPlusTreeNode>
    
    // Block to have a clean/dirty flag.
    
    // Promote pages or promote blocks?
    //   Blocks - assumes that system does magic to promote 
    //   Demote? No == put().
    //    Page extends Block?
    
    // See all : // [TxTDB:PATCH-UP]
    // Memory mapped files.
    // Avoid reparsing root blocks.  Maybe release only after change.
    
    /*
     * Layers:
     *   DatasetGraph
     *   Indexes
     *   Pages
     *   Blocks
     *   Storage = FileAccess (a sequence of blocks) 
     */
    
    /* NEXT
     * BPTreeNode - recursive operations to be static functions.
     *   Makes release conordination easier.
     * 2 phase:
     *   Fixup B+Tree/B-Tree by always asking to write blocks.  Marked [TxTDB:PATCH-UP]
      * BlockType arg to Block() makes no sense - may not know in advance.
     *   Separately rewrite to be better.
     * Fast B+Tree creation: wrap an existsing BPTree with another that switches the block managers only. 
     *   Later.
     * Setup
     *   Transaction start: grab alloc id.
     */
}
