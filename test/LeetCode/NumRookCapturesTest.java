package LeetCode;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumRookCapturesTest {
    @Test
    public void numRookCaptures() throws Exception {
        char[][] p = {
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','R','.','.','.','p'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'}};

        NumRookCaptures n = new NumRookCaptures();
        System.out.println(n.numRookCaptures(p));

    }

}