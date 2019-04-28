package Hellowworld;

public class Request {

	public static String FRFloorchange(String TargetDirection, Integer AimFloor, double Sendtime,Integer NowFloor,double RunningTime) {
		
		if ((AimFloor == 1 && TargetDirection.equals("DOWN"))) {
			return "ERROR1";
		} else if ((AimFloor == 10 && TargetDirection.equals("UP"))) {
			return "ERROR2";
		} else if (RunningTime > Sendtime) {
			System.out.println(RunningTime + " " + Sendtime);
			return "ERROR3";
		} else {
			if (AimFloor == NowFloor) {
				Sendtime += 1f;
				RunningTime = Sendtime;
				Elevator.setRunningTime(RunningTime);
				Elevator.setNowFloor(NowFloor);
				return "STILL";
			}
			Sendtime += Math.abs(AimFloor - NowFloor) * 0.5;
			RunningTime = Sendtime;
			if (NowFloor < AimFloor) {
				NowFloor = AimFloor;
				Elevator.setNowFloor(NowFloor);
				Elevator.setRunningTime(RunningTime);
				return "UP";
			} else {
				NowFloor = AimFloor;
				Elevator.setNowFloor(NowFloor);
				Elevator.setRunningTime(RunningTime);
				return "DOWN";
			}
		}
	}

	public static String ERFloorchange(Integer AimFloor, double Sendtime) {
		// Elevator elevator = new Elevator();
		double RunningTime = Elevator.getRunningTime();
		Integer NowFloor = Elevator.getNowFloor();
		if (RunningTime > Sendtime) {
			return "ERROR3";
		} else if (AimFloor < 0 || AimFloor > 10) {
			return "ERROR4";
		}
		if (NowFloor == AimFloor) {
			Sendtime += 1f;
			RunningTime = Sendtime;
			Elevator.setNowFloor(NowFloor);
			Elevator.setRunningTime(RunningTime);
			return "STILL";
		} else {
			Sendtime += Math.abs(AimFloor - NowFloor) * 0.5;
			RunningTime = Sendtime;
			if (NowFloor > AimFloor) {
				NowFloor = AimFloor;
				Elevator.setNowFloor(NowFloor);
				Elevator.setRunningTime(RunningTime);
				return "DOWN";
			} else {
				NowFloor = AimFloor;
				Elevator.setNowFloor(NowFloor);
				Elevator.setRunningTime(RunningTime);
				return "UP";
			}
		}
	}

	public static void error() {
		RequestQueue requestQueue = new RequestQueue();
		while (true) {
			
			String sDirection;
			if (requestQueue.peek() == null) {
				break;
			} else if (requestQueue.peek().getMode().equals("FR")) {
//				System.out.println(requestQueue.peek().getNowFloor());
				requestQueue.poll();
				sDirection = Request.FRFloorchange(Elevator.getDirection(), Elevator.getAimFloor(),
						Elevator.getSendtime(),Elevator.getNowFloor(),Elevator.getRunningTime());
				if (sDirection.equals("ERROR1")) {
					System.out.println("ERROR");
					System.out.println("#1楼不能下。");
				} else if (sDirection.equals("ERROR2")) {
					System.out.println("ERROR");
					System.out.println("#顶楼不能上。");
				} else if (sDirection.equals("ERROR3")) {
					System.out.println("ERROR");
					System.out.println("#命令发送时间有误。");
				} else {
					System.out.println(
							"(" + Elevator.getNowFloor() + "," + sDirection + "," + Elevator.getRunningTime() + ")");
				}
				
			} else {
				 requestQueue.poll();
				sDirection = Request.ERFloorchange(Elevator.getAimFloor(), Elevator.getSendtime());
				if (sDirection.equals("ERROR3")) {
					System.out.println("ERROR");
					System.out.println("#命令发送时间有误。");
				} else if (sDirection.equals("ERROR4")) {
					System.out.println("ERROR");
					System.out.println("#命令目标楼层有误。");
				} else {
					System.out.println(
							"(" + Elevator.getNowFloor() + "," + sDirection + "," + Elevator.getRunningTime() + ")");
				}
			}
		}
	}
	}