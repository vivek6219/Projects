#include <iostream>
#include <cstdlib>
#include "bst.h"

using namespace std;

struct node
{
    int key;
    node *left;
    node *right;
};

bst::bst()
{
    root = NULL;
}
bst::node bst::*createLeaf(int key)
{
    node* n = new node;
    n->key = key;
    n->right = NULL;
    n->left = NULL;
    
    return n;
}

void bst::addLeaf(int key)
{
    addLeafPrivate(key, root);
}

void bst::addLeafPrivate(int key, node *ptr)
{
    if(root ==NULL) //tree is empty
    {
        root = createLeaf(key);
    }
    else if(key<ptr->key)
    {
        if(ptr->left !=NULL)
        {
            addLeafPrivate(key,ptr->left);
        }
        else
        {
            ptr->left = createLeaf(key); 
        }
        
    }
    else if( key>ptr->key)
    {
        if(ptr->right !=NULl)
        {
            addLeafPrivate(key,ptr->right);
        }
        else
        {
            ptr->right = createLeaf(key);
        }
    }
    else
    {
        cout<<"Key" << key <<"already exists in tree"<<endl;
    }
    
}

void bst::printInOrder()
{
    printInOrderPrivate(root);
}

void bst::printInOrderPrivate(node *ptr)
{
    if(root !=NULL)
    {
        if(ptr->left != NULL)
        {
            printInOrderPrivate(ptr->left);
        }
        cout<<ptr->key << " ";

        if(ptr->right!=NULL)
        {
            printInOrderPrivate(ptr->right);
        }
    }
    else
    {
        cout<<"Empty tree" <<endl;
    }
}

void bst::RemoveNode(int key)
{
    RemoveNodePrivate(key,root);
}

void bst::RemoveNodePrivate(int key, node* parent)
{
    if(root!=NULL)
    {
        if(root->key ==key)
        {
            RemoveRootMatch();
        }
        else
        {
            if(key<parent->key && parent->left !=NULL)
            {
                parent->left->key ==key?
                RemoveMatch(parent, parent->left, true);
                RemoveNodePrivate(key,parent->left);
            }
            else if(key>parent->key && parent->right !=NULL)
            {
                parent->right->key ==key?
                RemoveMatch(parent, parent->right, false);
                RemoveNodePrivate(key,parent->right);
            }
        }
    }
    else{
        //if empty
        cout<<"Empty tree"<<endl;
    }
}

void RemoveRootMatch()
{
    //helper function to delete root
}
