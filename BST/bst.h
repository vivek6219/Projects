class bst
{
    private:
        node* root;
        void addLeafPrivate(int key, node *ptr);
        void printInOrderPrivate(node* ptr);
        void RemoveNodePrivate(int key, node* parent);


    public:
        bst();
        node* createLeaf(int key);
        void addLeaf(int key);
        void printInOrder();
        void RemoveNode(int key);
};