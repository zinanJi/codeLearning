package LeetCode;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GenerateTreesTest {
    @Test
    public void generateTrees() throws Exception {
        GenerateTrees generateTrees = new GenerateTrees();

        List<GenerateTrees.TreeNode> treeNodes = generateTrees.generateTrees(3);
        for(int i = 0;i < treeNodes.size();i++){
            System.out.println(treeNodes.get(i).val);
        }
    }

}