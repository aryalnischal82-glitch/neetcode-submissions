class WordDictionary {
    Node root;
    boolean found;
    public WordDictionary() {
         this.root=new Node();
         this.found=false;
    }

    public void addWord(String word) {
        Node curr=root;
        for(char c: word.toCharArray()){
            
            if(curr.children[c-'a']==null){
                curr.children[c-'a']=new Node();
            }
            curr=curr.children[c-'a'];
        }
        curr.isLeaf=true;
    }

    public boolean search(String word) {
       this.found=false;
       dfs(word,root,0);
       return this.found;
    }

    private void dfs(String word, Node node, int idx){
        if(node==null) return;
        if(idx==word.length()){
            if(node.isLeaf) this.found=true;
            return;
        }
        Node curr=node;
        if(word.charAt(idx)=='.'){
            for(int i=0;i<node.children.length;i++){
                if(curr.children[i]!=null) dfs(word,curr.children[i],idx+1);
            }
            }else{
               if(curr.children[word.charAt(idx)-'a']!=null) dfs(word,curr.children[word.charAt(idx)-'a'],idx+1);
            }
        }
       
    
}


class Node{
    Node[] children;
    boolean isLeaf;

    public Node(){
       this.children=new Node[26];
       this.isLeaf=false;
    }
}
