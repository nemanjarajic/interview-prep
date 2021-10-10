package Facebook;
import java.util.*;

import javax.swing.tree.TreeNode;

public class rightSideView {
    public static List<Integer> solution(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                TreeNode t = q.poll();

                if(t.left != null) q.add(t.left);
                if(t.right != null) q.add(t.right);

                if(i == size -1) res.add(t.val);
            }
        }
        
        return res;
    }
}
