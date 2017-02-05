/**
 * Created by Tigier on 03.02.2017.
 */
public class TList<ContentType> {

    private class TNode {

        private ContentType content = null;
        private TNode next = null;
        private TNode previous  = null;

        /**
         * A new TNode object is created and is given content.
         *
         * @param content
         */
        public TNode(ContentType content) {
            this.content = content;
            this.next = null;
            this.previous = null;
        }

        /**
         * Sets next to an object of the type TNode<ContentType>.
         *
         * @param next node following this in the list.
         */
        public void setNext(TNode next){
            this.next = next;
        }

        /**
         * Sets previous to an object of the type TNode<ContentType>.
         *
         * @param previous node leading this in the list.
         */
        public void setPrevious(TNode previous){
            this.previous = previous;
        }

        /**
         * Returns the node following this.
         *
         * @return next
         */
        public TNode getNext() {
            return this.next;
        }

        /**
         * Returns the node preceding this.
         *
         * @return previous
         */
        public TNode getPrevious() {
            return this.previous;
        }

        /**
         * Returns the content of this.
         *
         * @return content
         */
        public ContentType getContent() {
            return this.content;
        }
    }

    private TNode first;
    private TNode last;
    private TNode current;

    /**
     * A new, empty TList object is created.
     */
    public TList() {
        this.first = null;
        this.last = null;
        this.current = null;
    }

    /**
     *List/Queue/Stack
     *
     * @return true if the list does not contain nodes.
     */
    public boolean isEmpty() {
        return this.first == null;
    }

    public boolean hasAccess() {
        return this.current != null;
    }

    public void next() {
        if(hasAccess()) {
            this.current = current.getNext();
        }
    }

    public void toFirst() {
        this.current = this.first;
    }

    public void toLast() {
        this.current = this.first;
    }



    /**
     * Queue/Stack
     *
     * @return the content of the first node.
     */
    public ContentType first() {
        if(this.isEmpty()) {
            return null;
        }
        else {
            return this.first.getContent();
        }
    }

    /**
     * Queue
     *
     * A new TNode(content) is created and set as the last node in the list.
     *
     * @param content used for the TNode constructor call.
     */
    public void enqueue(ContentType content) {
        if(content != null) {
            TNode node = new TNode(content);
            if(this.isEmpty()) {
                this.first = node;
                this.last = this.first;
            }
            else {
                this.last.setNext(node);
                this.last = node;
            }
        }
    }

    /**
     * Queue
     *
     * Removes the first node if the list is not empty.
     */
    public void dequeue() {
        if(!this.isEmpty()) {
            this.first = this.first.getNext();
            if(this.isEmpty()) {
                this.last = this.first;
            }
        }
    }

    /**
     * Stack
     *
     * A new TNode(content) is created and set as the first node in the list.
     *
     * @param content used for the TNode constructor call.
     */
    public void push(ContentType content) {
        if(content != null) {
            TNode node = new TNode(content);
            node.setNext(this.first);
            this.first = node;
        }
    }

    /**
     * Stack
     *
     * Removes the first node if the list is not empty.
     */
    public void pop() {
        if(!this.isEmpty()) {
            this.first = this.first.getNext();
        }
    }

    public ContentType getContent() {
        if(hasAccess()) {
            return this.current.getContent();
        }
        else {
            return this.first();
        }
    }

    public ContentType getContent(int index) {
        if(!isEmpty()) {
            TNode output = this.first;
            for(int i = 0; i < index; i++) {
                if(output.getNext() == null){
                    return null;
                }
                output = output.getNext();
            }
            return output.getContent();
        }
        return null;
    }
}
