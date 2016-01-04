package structure.minimumSpanningTree;

public class Edge implements Comparable<Edge> {

	private double weight;
	private int either;
	private int other;

	public Edge(int v, int w, double weight) {
		this.weight = weight;
		this.either = v;
		this.other = w;
	}

	public double getWeight() {
		return weight;
	}

	public int getEither() {
		return either;
	}

	public int getOther(int v) {
		if (v == either) {
			return other;
		} else {
			return either;
		}
	}

	public int compareTo(Edge o) {
		if (o.weight < this.weight) {
			return 1;
		} else if (o.weight > this.weight) {
			return -1;
		} else {
			return 0;
		}
	}

	public String toString() {
		return "(" + either + ", " + other + "  " + weight + ")";
	}

}
