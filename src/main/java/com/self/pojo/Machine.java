package com.self.pojo;

/**
 * 设备
 * @author xuwenbin
 *
 *bit值保存为1/0，1代表true，0代表false
 *读取数据库数据时，可以直接用bool型读取该字段，会直接转换为true/false
 */

public class Machine {

	private  Integer seq;  //主键
	private  float ddelay; //超时时间
	private String ipadd;  //ip地址
	private String idadd;  //控制器机号
	private String areaid; 
	private String add;  //机号
	private String note00;//名称
	private String note1; //读卡机1名称
	private String note2; //读卡机2名称
	private String note3;
	private String note4;
	private String note5;
	private String note6;
	private String note7;
	private String note8;
	private String note9;
	private String note10; 
	private String note11;
	private String note12;
	private String note13;
	private String note14;
	private String note15;
	private String note16;
	private String note17;
	private String note18;
	private String note19;
	private String note20;
	private String note21;
	private String note22;
	private String note23;
	private String note24;
	private String note25;
	private String note26;
	private String note27;
	private String note28;
	private String note29;
	private String note30;
	private String note31;
	private String note32;//读卡机32名称
	
	private String kind; //ACS
	private String admpass; //999999
	private boolean isEnable; //是否启用
	private boolean setAttendance;
	private String location; 
	private String type;
	private String allStatus;
	private Integer ipPort; //端口号
	private String lockTime01;
	private String lockTime02;
	private String doorDelay01;
	private String doorDelay02;
	private String deviceMode; //44
	private Integer grp; //群组
	private boolean setAtt;
	private boolean faceIsUse1;
	private String faceIP1;
	private String faceIDPort1;
	private boolean faceStatus1;
	
	private boolean faceIsUse2;
	private String faceIP2;
	private String faceIDPort2;
	private boolean faceStatus2;
	
	private boolean vendorUse;
	private boolean mutiPinCode;
	private boolean elevator;
	private Integer elevatorNo;
	
	private String floor0;
	private String floor1;
	private String floor2;
	private String floor3;
	private String floor4;
	private String floor5;
	private String floor6;
	private String floor7;
	private String floor8;
	private String floor9;
	private String floor10;
	private String floor11;
	private String floor12;
	private String floor13;
	private String floor14;
	private String floor15;
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public float getDdelay() {
		return ddelay;
	}
	public void setDdelay(float ddelay) {
		this.ddelay = ddelay;
	}
	public String getIpadd() {
		return ipadd;
	}
	public void setIpadd(String ipadd) {
		this.ipadd = ipadd;
	}
	public String getIdadd() {
		return idadd;
	}
	public void setIdadd(String idadd) {
		this.idadd = idadd;
	}
	public String getAreaid() {
		return areaid;
	}
	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getNote00() {
		return note00;
	}
	public void setNote00(String note00) {
		this.note00 = note00;
	}
	public String getNote1() {
		return note1;
	}
	public void setNote1(String note1) {
		this.note1 = note1;
	}
	public String getNote2() {
		return note2;
	}
	public void setNote2(String note2) {
		this.note2 = note2;
	}
	public String getNote3() {
		return note3;
	}
	public void setNote3(String note3) {
		this.note3 = note3;
	}
	public String getNote4() {
		return note4;
	}
	public void setNote4(String note4) {
		this.note4 = note4;
	}
	public String getNote5() {
		return note5;
	}
	public void setNote5(String note5) {
		this.note5 = note5;
	}
	public String getNote6() {
		return note6;
	}
	public void setNote6(String note6) {
		this.note6 = note6;
	}
	public String getNote7() {
		return note7;
	}
	public void setNote7(String note7) {
		this.note7 = note7;
	}
	public String getNote8() {
		return note8;
	}
	public void setNote8(String note8) {
		this.note8 = note8;
	}
	public String getNote9() {
		return note9;
	}
	public void setNote9(String note9) {
		this.note9 = note9;
	}
	public String getNote10() {
		return note10;
	}
	public void setNote10(String note10) {
		this.note10 = note10;
	}
	public String getNote11() {
		return note11;
	}
	public void setNote11(String note11) {
		this.note11 = note11;
	}
	public String getNote12() {
		return note12;
	}
	public void setNote12(String note12) {
		this.note12 = note12;
	}
	public String getNote13() {
		return note13;
	}
	public void setNote13(String note13) {
		this.note13 = note13;
	}
	public String getNote14() {
		return note14;
	}
	public void setNote14(String note14) {
		this.note14 = note14;
	}
	public String getNote15() {
		return note15;
	}
	public void setNote15(String note15) {
		this.note15 = note15;
	}
	public String getNote16() {
		return note16;
	}
	public void setNote16(String note16) {
		this.note16 = note16;
	}
	public String getNote17() {
		return note17;
	}
	public void setNote17(String note17) {
		this.note17 = note17;
	}
	public String getNote18() {
		return note18;
	}
	public void setNote18(String note18) {
		this.note18 = note18;
	}
	public String getNote19() {
		return note19;
	}
	public void setNote19(String note19) {
		this.note19 = note19;
	}
	public String getNote20() {
		return note20;
	}
	public void setNote20(String note20) {
		this.note20 = note20;
	}
	public String getNote21() {
		return note21;
	}
	public void setNote21(String note21) {
		this.note21 = note21;
	}
	public String getNote22() {
		return note22;
	}
	public void setNote22(String note22) {
		this.note22 = note22;
	}
	public String getNote23() {
		return note23;
	}
	public void setNote23(String note23) {
		this.note23 = note23;
	}
	public String getNote24() {
		return note24;
	}
	public void setNote24(String note24) {
		this.note24 = note24;
	}
	public String getNote25() {
		return note25;
	}
	public void setNote25(String note25) {
		this.note25 = note25;
	}
	public String getNote26() {
		return note26;
	}
	public void setNote26(String note26) {
		this.note26 = note26;
	}
	public String getNote27() {
		return note27;
	}
	public void setNote27(String note27) {
		this.note27 = note27;
	}
	public String getNote28() {
		return note28;
	}
	public void setNote28(String note28) {
		this.note28 = note28;
	}
	public String getNote29() {
		return note29;
	}
	public void setNote29(String note29) {
		this.note29 = note29;
	}
	public String getNote30() {
		return note30;
	}
	public void setNote30(String note30) {
		this.note30 = note30;
	}
	public String getNote31() {
		return note31;
	}
	public void setNote31(String note31) {
		this.note31 = note31;
	}
	public String getNote32() {
		return note32;
	}
	public void setNote32(String note32) {
		this.note32 = note32;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getAdmpass() {
		return admpass;
	}
	public void setAdmpass(String admpass) {
		this.admpass = admpass;
	}
	public boolean isEnable() {
		return isEnable;
	}
	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
	}
	public boolean isSetAttendance() {
		return setAttendance;
	}
	public void setSetAttendance(boolean setAttendance) {
		this.setAttendance = setAttendance;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAllStatus() {
		return allStatus;
	}
	public void setAllStatus(String allStatus) {
		this.allStatus = allStatus;
	}
	public Integer getIpPort() {
		return ipPort;
	}
	public void setIpPort(Integer ipPort) {
		this.ipPort = ipPort;
	}
	public String getLockTime01() {
		return lockTime01;
	}
	public void setLockTime01(String lockTime01) {
		this.lockTime01 = lockTime01;
	}
	public String getLockTime02() {
		return lockTime02;
	}
	public void setLockTime02(String lockTime02) {
		this.lockTime02 = lockTime02;
	}
	public String getDoorDelay01() {
		return doorDelay01;
	}
	public void setDoorDelay01(String doorDelay01) {
		this.doorDelay01 = doorDelay01;
	}
	public String getDoorDelay02() {
		return doorDelay02;
	}
	public void setDoorDelay02(String doorDelay02) {
		this.doorDelay02 = doorDelay02;
	}
	public String getDeviceMode() {
		return deviceMode;
	}
	public void setDeviceMode(String deviceMode) {
		this.deviceMode = deviceMode;
	}
	public Integer getGrp() {
		return grp;
	}
	public void setGrp(Integer grp) {
		this.grp = grp;
	}
	public boolean isSetAtt() {
		return setAtt;
	}
	public void setSetAtt(boolean setAtt) {
		this.setAtt = setAtt;
	}
	public boolean isFaceIsUse1() {
		return faceIsUse1;
	}
	public void setFaceIsUse1(boolean faceIsUse1) {
		this.faceIsUse1 = faceIsUse1;
	}
	public String getFaceIP1() {
		return faceIP1;
	}
	public void setFaceIP1(String faceIP1) {
		this.faceIP1 = faceIP1;
	}
	public String getFaceIDPort1() {
		return faceIDPort1;
	}
	public void setFaceIDPort1(String faceIDPort1) {
		this.faceIDPort1 = faceIDPort1;
	}
	public boolean isFaceStatus1() {
		return faceStatus1;
	}
	public void setFaceStatus1(boolean faceStatus1) {
		this.faceStatus1 = faceStatus1;
	}
	public boolean isFaceIsUse2() {
		return faceIsUse2;
	}
	public void setFaceIsUse2(boolean faceIsUse2) {
		this.faceIsUse2 = faceIsUse2;
	}
	public String getFaceIP2() {
		return faceIP2;
	}
	public void setFaceIP2(String faceIP2) {
		this.faceIP2 = faceIP2;
	}
	public String getFaceIDPort2() {
		return faceIDPort2;
	}
	public void setFaceIDPort2(String faceIDPort2) {
		this.faceIDPort2 = faceIDPort2;
	}
	public boolean isFaceStatus2() {
		return faceStatus2;
	}
	public void setFaceStatus2(boolean faceStatus2) {
		this.faceStatus2 = faceStatus2;
	}
	public boolean isVendorUse() {
		return vendorUse;
	}
	public void setVendorUse(boolean vendorUse) {
		this.vendorUse = vendorUse;
	}
	public boolean isMutiPinCode() {
		return mutiPinCode;
	}
	public void setMutiPinCode(boolean mutiPinCode) {
		this.mutiPinCode = mutiPinCode;
	}
	public boolean isElevator() {
		return elevator;
	}
	public void setElevator(boolean elevator) {
		this.elevator = elevator;
	}
	public Integer getElevatorNo() {
		return elevatorNo;
	}
	public void setElevatorNo(Integer elevatorNo) {
		this.elevatorNo = elevatorNo;
	}
	public String getFloor0() {
		return floor0;
	}
	public void setFloor0(String floor0) {
		this.floor0 = floor0;
	}
	public String getFloor1() {
		return floor1;
	}
	public void setFloor1(String floor1) {
		this.floor1 = floor1;
	}
	public String getFloor2() {
		return floor2;
	}
	public void setFloor2(String floor2) {
		this.floor2 = floor2;
	}
	public String getFloor3() {
		return floor3;
	}
	public void setFloor3(String floor3) {
		this.floor3 = floor3;
	}
	public String getFloor4() {
		return floor4;
	}
	public void setFloor4(String floor4) {
		this.floor4 = floor4;
	}
	public String getFloor5() {
		return floor5;
	}
	public void setFloor5(String floor5) {
		this.floor5 = floor5;
	}
	public String getFloor6() {
		return floor6;
	}
	public void setFloor6(String floor6) {
		this.floor6 = floor6;
	}
	public String getFloor7() {
		return floor7;
	}
	public void setFloor7(String floor7) {
		this.floor7 = floor7;
	}
	public String getFloor8() {
		return floor8;
	}
	public void setFloor8(String floor8) {
		this.floor8 = floor8;
	}
	public String getFloor9() {
		return floor9;
	}
	public void setFloor9(String floor9) {
		this.floor9 = floor9;
	}
	public String getFloor10() {
		return floor10;
	}
	public void setFloor10(String floor10) {
		this.floor10 = floor10;
	}
	public String getFloor11() {
		return floor11;
	}
	public void setFloor11(String floor11) {
		this.floor11 = floor11;
	}
	public String getFloor12() {
		return floor12;
	}
	public void setFloor12(String floor12) {
		this.floor12 = floor12;
	}
	public String getFloor13() {
		return floor13;
	}
	public void setFloor13(String floor13) {
		this.floor13 = floor13;
	}
	public String getFloor14() {
		return floor14;
	}
	public void setFloor14(String floor14) {
		this.floor14 = floor14;
	}
	public String getFloor15() {
		return floor15;
	}
	public void setFloor15(String floor15) {
		this.floor15 = floor15;
	}

}
