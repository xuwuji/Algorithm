package structure.array;

/**
 * In a linked list, lookup is always an O(n) operation, but array lookup is
 * O(1) as long as you know the index of the element you want.
 * 
 * 
 * The price for this improved lookup is signi cantly decreased ef ciency for
 * insertion and dele- tion of data in the middle of the array. Because an array
 * is essentially a block of contiguous memory, it’s not possible to create or
 * eliminate storage between any two elements as it is with a linked list.
 * Instead, you must physically move data within the array to make room for an
 * insertion or to close the gap left by a deletion; this is an O(n) operation.
 * 
 * Most modern languages also have library support for dynamic arrays: arrays
 * that can change size to store as much or as little data as necessary. (Some
 * languages, typically scripting languages, use dynamic arrays as their
 * fundamental array type and have no static array type.) This discussion won’t
 * go into the details of implementing a dynamic array, but you should know that
 * most dynamic array implementations use static arrays internally. A static
 * array cannot be resized, so dynamic arrays are resized by allocating a new
 * array of the appropriate size, copying every element from the old array into
 * the new array, and freeing the old array. This is an expensive operation that
 * should be done as infrequently as possible.
 * 
 * @author wuxu 2016-3-1
 *
 */
public class Array {

}
