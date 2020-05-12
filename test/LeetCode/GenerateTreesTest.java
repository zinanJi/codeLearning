package LeetCode;

import LeetCode.owner.Tree.middle.GenerateTrees_95;
import org.junit.Test;

import java.util.List;

public class GenerateTreesTest {
    @Test
    public void generateTrees() throws Exception {
        GenerateTrees_95 generateTrees = new GenerateTrees_95();

        List<GenerateTrees_95.TreeNode> treeNodes = generateTrees.generateTrees(3);
        for(int i = 0;i < treeNodes.size();i++){
            System.out.println(treeNodes.get(i).val);
        }
    }

}
