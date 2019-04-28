package Hellowworld;

import java.util.LinkedList;

class Dispatcher {

	public static void dispatcher() {

		Input input = new Input();
		LinkedList<String> list = input.getList();
		RequestQueue requestQueue = new RequestQueue();
		while (true) {
			Elevator elevator = new Elevator();
			if (list.isEmpty()) {
				list = input.getList();
			}

			String Command[] = input.inputAcquisition(list.poll());

			if (Command[0].equals("FR")) {
				Elevator.setMode(Command[0]);
				Elevator.setAimFloor(Integer.valueOf(Command[1]));
				Elevator.setDirection(Command[2]);
				Elevator.setSendtime(Double.valueOf(Command[3]));
				requestQueue.addRequest(elevator);

			}

			else if (Command[0].equals("ER")) {
				Elevator.setMode(Command[0]);
				Elevator.setAimFloor(Integer.valueOf(Command[1]));
				Elevator.setSendtime(Double.valueOf(Command[2]));
				requestQueue.addRequest(elevator);

			}
			Request.error();

		}

	}
}