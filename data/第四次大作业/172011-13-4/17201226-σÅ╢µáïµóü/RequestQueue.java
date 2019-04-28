package Hellowworld;

import java.util.LinkedList;
import java.util.Queue;

//«Î«Û∂”¡–
public class RequestQueue {
	private static Queue<Elevator> queue = new LinkedList<Elevator>(); 
	public void addRequest(Elevator elevator) {
		queue.offer(elevator);
	}

	public Elevator peek() {
		return queue.peek();
	}
	public Elevator poll() {
		return queue.poll();
	}
}