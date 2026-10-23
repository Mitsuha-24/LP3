import java.util.*;

class Node implements Comparable<Node> {
    char c; int f; Node l, r;
    Node(char c, int f) { this.c = c; this.f = f; }
    Node(int f, Node l, Node r) { this.f = f; this.l = l; this.r = r; }
    public int compareTo(Node o) { return f - o.f; }
}

public class Huffman {
    static void code(Node n, String s, Map<Character, String> m) {
        if (n == null) return;
        if (n.l == null && n.r == null) m.put(n.c, s);
        code(n.l, s + "0", m);
        code(n.r, s + "1", m);
    }

    public static void main(String[] args) {
        String t = "abracadabra";
        Map<Character, Integer> f = new HashMap<>();
        for (char c : t.toCharArray()) f.put(c, f.getOrDefault(c, 0) + 1);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        f.forEach((c, cnt) -> pq.add(new Node(c, cnt)));

        while (pq.size() > 1) pq.add(new Node(0, pq.poll(), pq.poll()));

        Map<Character, String> codes = new HashMap<>();
        code(pq.peek(), "", codes);

        System.out.println("Codes: " + codes);
        for (char c : t.toCharArray()) System.out.print(codes.get(c));
    }
}