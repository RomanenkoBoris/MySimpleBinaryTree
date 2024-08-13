import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyBinaryTreeTest {
    private MyBinaryTree<Integer> tree;
    private MyBinaryTree<String> emptyTree = new MyBinaryTree<>(null);


    @BeforeEach
    void setUp() {
        MyBinaryTree.Vortex<Integer> v5 = new MyBinaryTree.Vortex<>(5);
        MyBinaryTree.Vortex<Integer> v7 = new MyBinaryTree.Vortex<>(7);
        MyBinaryTree.Vortex<Integer> v6 = new MyBinaryTree.Vortex<>(6, v5, v7);
        MyBinaryTree.Vortex<Integer> v10 = new MyBinaryTree.Vortex<>(10);
        MyBinaryTree.Vortex<Integer> v8 = new MyBinaryTree.Vortex<>(8, v6, v10);
        tree = new MyBinaryTree<>(v8);
    }

    @Test
    void testCountVertexesEmptyTree() {
        assertEquals(0, emptyTree.countVertexes());
    }

    @Test
    void testCountVertexesMultipleElementTree() {
        assertEquals(5, tree.countVertexes());
    }

    @Test
    void testDepthEmptyTree() {
        assertEquals(0, emptyTree.depth());
    }

    @Test
    void testDepthMultipleElementTree() {
        assertEquals(3, tree.depth());
    }

    @Test
    void testContainsNullPointerException() {
        NullPointerException npe = assertThrows(NullPointerException.class, () -> tree.contains(null));
        assertEquals("Please enter a correct value", npe.getMessage());
    }

    @Test
    void testContainsEmptyTree() {
        assertEquals(0, emptyTree.countVertexes());
        assertFalse(emptyTree.contains("one"));
    }

    @Test
    void testContainsMultipleElementTree() {
        assertEquals(5, tree.countVertexes());
        assertTrue(tree.contains(5));
        assertTrue(tree.contains(7));
        assertFalse(tree.contains(9));
        assertFalse(tree.contains(4));
    }

    @Test
    void testAddNullPointerException() {
        NullPointerException npe = assertThrows(NullPointerException.class, () -> emptyTree.add(null));
        assertEquals("Please enter a correct value", npe.getMessage());
    }

    @Test
    void testAddEmptyTree() {
        assertEquals(0, emptyTree.countVertexes());
        emptyTree.add("one");
        emptyTree.add("two");
        emptyTree.add("three");
        assertEquals(3, emptyTree.countVertexes());
        assertEquals(3, emptyTree.depth());
        assertTrue(emptyTree.contains("one"));
        assertTrue(emptyTree.contains("two"));
        assertTrue(emptyTree.contains("three"));
    }

    @Test
    void testMultiElementTree() {
        assertEquals(5, tree.countVertexes());
        assertFalse(tree.contains(9));
        tree.add(9);
        assertEquals(6, tree.countVertexes());
        assertTrue(tree.contains(9));
        assertFalse(tree.contains(4));
        tree.add(4);
        assertEquals(7, tree.countVertexes());
        assertTrue(tree.contains(4));
    }

    @Test
    void testToStringEmptyTree() {
        assertEquals(0, emptyTree.countVertexes());
        assertEquals("{}", emptyTree.toString());
    }

    @Test
    void testToStringMultipleElementTree() {
        assertEquals(5, tree.countVertexes());
        assertEquals("{\"left\":{\"left\":{\"left\":{}, \"value\": 5, \"right\":{}}, \"value\": 6, \"right\":{\"left\":{}, \"value\": 7, \"right\":{}}}, \"value\": 8, \"right\":{\"left\":{}, \"value\": 10, \"right\":{}}}", tree.toString());
    }

}