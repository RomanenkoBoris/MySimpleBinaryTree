public class MyBinaryTree<V extends Comparable<V>> {
    private Vortex<V> root;

    public MyBinaryTree(Vortex<V> root) {
        this.root = root;
    }

    public int countVertexes() {
        return root == null ? 0 : root.countVertexes();
    }

    public int depth() {
        return root == null ? 0 : root.depth();
    }

    public boolean contains(V value) {
        throwNullPointerException(value);
        return containsRecursive(root, value);
    }

    public void add(V value) {
        throwNullPointerException(value);
        root = addRecursive(root, value);
    }

    @Override
    public String toString() {
        return root.toString();
    }

    private boolean containsRecursive(Vortex vortex, V value) {
        if (vortex == null)
            return false;
        if (vortex.value.equals(value))
            return true;
        else if (vortex.value.compareTo(value) < 0)
            return containsRecursive(vortex.right, value);
        else
            return containsRecursive(vortex.left, value);
    }

    private Vortex addRecursive(Vortex<V> vortex, V value) {
        if (vortex == null)
            return new Vortex<>(value);
        if (vortex.value.compareTo(value) < 0)
            vortex.right = addRecursive(vortex.right, value);
        else if (vortex.value.compareTo(value) > 0)
            vortex.left = addRecursive(vortex.left, value);
        return vortex;
    }

    private void throwNullPointerException(V value) {
        if (value == null)
            throw new NullPointerException("Please enter a correct value");
    }

    static class Vortex<V extends Comparable<V>> {
        private V value;
        private Vortex<V> left;
        private Vortex<V> right;

        public Vortex(V value) {
            this.value = value;
        }

        public Vortex(V value, Vortex<V> left, Vortex<V> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        private int countVertexes() {
            return 1 + (left == null ? 0 : left.countVertexes()) + (right == null ? 0 : right.countVertexes());
        }

        private int depth() {
            return 1 + Math.max(left == null ? 0 : left.depth(), right == null ? 0 : right.depth());
        }


        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{");
            stringBuilder.append("\"left\":");
            stringBuilder.append(left == null ? "{}" : left.toString());
            stringBuilder.append(", \"value\": " + value + ", \"right\":");
            stringBuilder.append(right == null ? "{}" : right.toString());
            return stringBuilder.append("}").toString();
        }
    }
}
