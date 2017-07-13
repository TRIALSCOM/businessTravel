package com.businessTravel.util;



public class BusinessConstant {
    public static final String  ACTIVEY="Y";    //̬用户处于激活状态
    public  static final String  ACTIVEN="N";   //用户处于未激活状态״̬
    
    public  static final int K_TRAIN_CATEGORY=2;    //普快
	public  static final int D_TRAIN_CATEGORY=0;   //动车
	public  static final int G_TRAIN_CATEGORY=1;    //高铁
	
	public static final Integer TRAIN_DAY_FIRST=0;    //当天到
	public static final Integer TRAIN_DAY_SECOND=1;    //第二天到
	public static final Integer TRAIN_DAY_THIRD=2;     //第三天到
	
	/*
	 * 票的种类
	 */
	public static final String SEAT_STAND="站票";
	public static final String SEAT_HARD="硬座";
	public static final String COACH_HARD="硬卧";
	public static final String COACH_SOFT="软卧";
	public static final String SEAT_FIRST="一等座";
	public static final String SEAT_SECOND="二等座";
	public static final String SEAT_SPECIAL="商务座";
	
	
	
	public static final String K_TRIANS=SEAT_STAND+SEAT_HARD+COACH_HARD+COACH_SOFT;
	public static final String O_TRAINS=SEAT_FIRST+SEAT_SPECIAL+SEAT_SECOND;
	
	/*
	 * 床型
	 */
	public static final String KING_BED="大床房";
	public static final String MEDIUM_BED="中型房";
	public static final String SMALL_BED="小型房";
	
	/*
	 * 审核状态
	 */
	public static final Integer UNAPPLY=0;//未申请审核
	public static final Integer UNFINSH=1;//审核未完成
	public static final Integer FINSH=-1;//审核完成
	
	public static final String[]INGORE_URI={"modifyPassword","/resetPassword","/home","/index","/login","/loginForm","/sign-up","/forgot",
			  "/confirmMail","/re-info","/signUp","/comfirmSignUp","/register","/fileUp","downLoadFile","downFile","/beanToPdfRich","/richStudPdfView","/change-info","/goToChangeInfo",
			  "forgetPassword"};
	
	
	
	
	//火车：硬座，站票一样，硬卧=2倍，软卧=3倍

	//高铁1等=1.8倍，头等=3倍
	
	 //中=最低x1.25倍  高=中x1.25 5星
	 //		分别是最低的1.5，2倍 3星
	
     //动车：二等和无座一样，一等=1.2倍
	
}
