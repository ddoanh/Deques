# Deques (https://fa22.datastructur.es/materials/proj/proj1/#2-array-deque)
- Deque (usually pronounced like “deck”) is an irregular acronym of double-ended queue. Double-ended queues are sequence containers with dynamic sizes that can be expanded or contracted on both ends (either its front or its back).
- Implementations of a “Double Ended Queue” using both lists and arrays in a package
## Deque API
Operations: 
</p>

<ul>
  <li><code class="language-plaintext highlighter-rouge">public void addFirst(T item)</code>: Adds an item of type <code class="language-plaintext highlighter-rouge">T</code> to the front of the deque. You can assume that <code class="language-plaintext highlighter-rouge">item</code> is
never <code class="language-plaintext highlighter-rouge">null</code>.</li>
  <li><code class="language-plaintext highlighter-rouge">public void addLast(T item)</code>: Adds an item of type <code class="language-plaintext highlighter-rouge">T</code> to the back of the deque. You can assume that <code class="language-plaintext highlighter-rouge">item</code> is
never <code class="language-plaintext highlighter-rouge">null</code>.</li>
  <li><code class="language-plaintext highlighter-rouge">public boolean isEmpty()</code>: Returns <code class="language-plaintext highlighter-rouge">true</code> if deque is empty, <code class="language-plaintext highlighter-rouge">false</code> otherwise.</li>
  <li><code class="language-plaintext highlighter-rouge">public int size()</code>: Returns the number of items in the deque.</li>
  <li><code class="language-plaintext highlighter-rouge">public void printDeque()</code>: Prints the items in the deque from first to last, separated by a space. Once all the items
have been printed, print out a new line.</li>
  <li><code class="language-plaintext highlighter-rouge">public T removeFirst()</code>: Removes and returns the item at the front of the deque. If no such item exists,
returns <code class="language-plaintext highlighter-rouge">null</code>.</li>
  <li><code class="language-plaintext highlighter-rouge">public T removeLast()</code>: Removes and returns the item at the back of the deque. If no such item exists, returns <code class="language-plaintext highlighter-rouge">null</code>
.</li>
  <li><code class="language-plaintext highlighter-rouge">public T get(int index)</code>: Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
If no such item exists, returns <code class="language-plaintext highlighter-rouge">null</code>. Must not alter the deque!</li>
  <li><code class="language-plaintext highlighter-rouge">public Iterator&lt;T&gt; iterator()</code>: The deques objects we’ll make are iterable (i.e. <code class="language-plaintext highlighter-rouge">Iterable&lt;T&gt;</code>)
so we must provide this method to return an iterator.</li>
  <li><code class="language-plaintext highlighter-rouge">public boolean equals(Object o)</code>: Returns whether or not the parameter <code class="language-plaintext highlighter-rouge">o</code> is equal to the deque. <code class="language-plaintext highlighter-rouge">o</code> is considered
equal if it is a deque and if it contains the same contents (as determined by the generic <code class="language-plaintext highlighter-rouge">T</code>’s <code class="language-plaintext highlighter-rouge">equals</code> method) in
the same order.
