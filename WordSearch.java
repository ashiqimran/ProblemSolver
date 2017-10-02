    /**
     * Created by ashiqimran on 10/2/17.
     */
    public class WordSearch{
        public static void main(String args[]){
            String words[] = {"the", "a", "there",
                    "answer", "any", "by",
                    "bye", "their" };

            Trie root = new Trie();
            for(int i = 0; i < words.length; i++){
                root.insert(words[i]);
            }
            System.out.println(root.search("bye"));
        }
    }


    class Trie {

        private TrieNode root;
        Trie(){
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode p = root;
            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                int index = c-'a';
                if(p.arr[index]==null){
                    TrieNode temp = new TrieNode();
                    p.arr[index]=temp;
                    p = temp;
                }else{
                    p=p.arr[index];
                }
            }
            p.isEnd=true;
        }



        public boolean search(String word) {
            TrieNode p = searchNode(word);
            if(p==null){
                return false;
            }else{
                if(p.isEnd)
                    return true;
            }

            return false;
        }
            // Returns if there is any word in the trie
            // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            TrieNode p = searchNode(prefix);
            if(p==null){
                return false;
            }else{
                return true;
            }
        }

        public TrieNode searchNode(String s){
            TrieNode p = root;
            for(int i=0; i<s.length(); i++){
                char c= s.charAt(i);
                int index = c-'a';
                if(p.arr[index]!=null){
                    p = p.arr[index];
                }else{
                    return null;
                }
            }

            if(p==root)
                return null;

            return p;
        }
    }

    class TrieNode {
        TrieNode[] arr;
        boolean isEnd;
        // Initialize your data structure here.
        public TrieNode() {
            this.arr = new TrieNode[26];
        }

    }
