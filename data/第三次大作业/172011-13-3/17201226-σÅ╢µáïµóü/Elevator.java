package Hellowworld;

class Elevator {

	private static String Mode;
	private static double Sendtime;
	private static String Direction;
	private static Integer AimFloor;
	private static Integer NowFloor = 1;
	private static double RunningTime = 0;

	public static double getSendtime() {
		return Sendtime;
	}

	public static void setSendtime(double sendtime) {
		Sendtime = sendtime;
	}

	public String getMode() {
		return Mode;
	}

	public static void setMode(String mode) {
		Mode = mode;
	}

	public static String getDirection() {
		return Direction;
	}

	public static void setDirection(String direction) {
		Direction = direction;
	}

	public static Integer getAimFloor() {
		return AimFloor;
	}

	public static void setAimFloor(Integer aimFloor) {
		AimFloor = aimFloor;
	}

	public static Integer getNowFloor() {
		return NowFloor;
	}

	public static void setNowFloor(Integer nowFloor) {
		NowFloor = nowFloor;
	}

	public static double getRunningTime() {
		return RunningTime;
	}

	public static void setRunningTime(double runningTime) {
		RunningTime = runningTime;
	}

}