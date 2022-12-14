package com.example.minicrm.bussiness;

import android.graphics.Typeface;

import com.example.minicrm.app.ApplicationMiniCrm;


public class FontBussiness {

	private Typeface mRobotoLight;
	private Typeface mRobotoBold;
	private Typeface mRobotoRegular;
	private Typeface mRobotoMedium;
	
	private Typeface mOpenSanLight;
	private Typeface mOpenSanBold;
	private Typeface mOpenSanRegular;
	private Typeface mOpenSanSemiBold;
	private ApplicationMiniCrm mIposManage;

	private Typeface mSanfanciscoRegular;
	private Typeface mSanfanciscoMedium;
	private Typeface mSanfanciscoSemibold;
	private Typeface mSanfanciscoBold;

	public FontBussiness(ApplicationMiniCrm mIpos) {
		this.mIposManage = mIpos;
		mRobotoMedium = Typeface.createFromAsset(mIpos.getAssets(),
				"fonts/Roboto-Medium.ttf");
		mRobotoLight = Typeface.createFromAsset(this.mIposManage.getAssets(),
				"fonts/Roboto-Light.ttf");
		mRobotoRegular = Typeface.createFromAsset(this.mIposManage.getAssets(),
				"fonts/Roboto-Regular.ttf");
		mRobotoBold = Typeface.createFromAsset(this.mIposManage.getAssets(),
				"fonts/Roboto-Bold.ttf");
		
		
		mOpenSanSemiBold = Typeface.createFromAsset(this.mIposManage.getAssets(),
				"fonts/OpenSans-Semibold.ttf");
		mOpenSanLight = Typeface.createFromAsset(this.mIposManage.getAssets(),
				"fonts/OpenSans-Light.ttf");
		mOpenSanRegular = Typeface.createFromAsset(this.mIposManage.getAssets(),
				"fonts/OpenSans-Regular.ttf");
		mOpenSanBold = Typeface.createFromAsset(this.mIposManage.getAssets(),
				"fonts/OpenSans-Bold.ttf");

		mSanfanciscoRegular = Typeface.createFromAsset(this.mIposManage.getAssets(),
				"fonts/SanFranciscoDisplay-Regular_1.otf");

		mSanfanciscoMedium = Typeface.createFromAsset(this.mIposManage.getAssets(),
				"fonts/SanFranciscoDisplay-Medium_1.otf");

		mSanfanciscoSemibold = Typeface.createFromAsset(this.mIposManage.getAssets(),
				"fonts/SanFranciscoDisplay-Semibold_1.otf");

		mSanfanciscoBold = Typeface.createFromAsset(this.mIposManage.getAssets(),
				"fonts/SanFranciscoDisplay-Bold_1.otf");
	}

	public Typeface getRobotoLight() {
		return mRobotoLight;
	}

	public Typeface getRobotoBold() {
		return mRobotoBold;
	}

	public Typeface getRobotoRegular() {
		return mRobotoRegular;
	}

	public Typeface getRobotoMedium() {
		return mRobotoMedium;
	}

	public Typeface getOpenSanLight() {
		return mOpenSanLight;
	}

	public Typeface getOpenSanBold() {
		return mOpenSanBold;
	}

	public Typeface getOpenSanRegular() {
		return mOpenSanRegular;
	}

	public Typeface getOpenSanSemiBold() {
		return mOpenSanSemiBold;
	}

	public Typeface getmSanfanciscoRegular() {
		return mSanfanciscoRegular;
	}

	public Typeface getmSanfanciscoMedium() {
		return mSanfanciscoMedium;
	}

	public Typeface getmSanfanciscoBold() {
		return mSanfanciscoBold;
	}

	public void setmSanfanciscoBold(Typeface mSanfanciscoBold) {
		this.mSanfanciscoBold = mSanfanciscoBold;
	}

	public Typeface getmSanfanciscoSemibold() {
		return mSanfanciscoSemibold;
	}

	public ApplicationMiniCrm getFoodBook() {
		return mIposManage;
	}
	
	
	
	
	
}
