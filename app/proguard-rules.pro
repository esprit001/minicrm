# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in D:\Android\android-sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
-optimizationpasses 5
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontpreverify
-verbose
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*
# toanvk2 comment
#Uncomment if using annotations to keep them.if using signature (facebook....)
-keepattributes *Annotation*
-keepattributes Signature
-keep class com.facebook.** { *; }

#Keep classes that are referenced on the AndroidManifest
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class com.android.vending.licensing.ILicensingService
-keep class org.openudid.** { *; }
-keep class ly.count.android.sdk.** { *; }
#-keep public class com.google.gson.**
#To remove debug logs:
-assumenosideeffects class android.util.Log {
 public static boolean isLoggable(java.lang.String, int);
    public static *** v(...);
    public static *** d(...);
    public static *** i(...);
    public static *** w(...);
    public static *** e(...);
}
-keepclassmembers,allowobfuscation class * {
  @com.google.gson.annotations.SerializedName <fields>;
}
#remove all
#-assumenosideeffects class android.util.Log { *; }

#Maintain java native methods
-keepclasseswithmembernames class * {
    native <methods>;
}

#To maintain custom components names that are used on layouts XML.

#To maintain custom components names that are used on layouts XML:
-keep public class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
    public void set*(...);
}
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
#Maintain enums
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
#To keep parcelable classes (to serialize - deserialize objects to sent through Intents)
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}
#aaaa
-keepnames class * implements android.os.Parcelable {
    public static final ** CREATOR;
}
#Keep the R
-keepclassmembers class **.R$* {
    public static <fields>;
}

#Uncomment if using Serializable
-keepclassmembers class * implements java.io.Serializable {
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

# actionbar sherlock
-keep class android.support.v4.app.** { *; }
-keep interface android.support.v4.app.** { *; }
-keep class com.actionbarsherlock.** { *; }
-keep interface com.actionbarsherlock.** { *; }
-keep class com.modul.marketplace.** { *; }
-keep interface com.modul.marketplace.** { *; }

# jar file
#-libraryjars libs/volley.jar
#-libraryjars libs/gson-2.2.1.jar
-keep class javax.** { *; }
#-keep class org.** { *; }

# Gson specific classes
-keep class sun.misc.Unsafe { *; }
#-keep class com.google.gson.stream.** { *; }
# Application classes that will be serialized/deserialized over Gson
#-keep class com.viettel.mocha.database.model.MediaModel { *; }
#-keep class com.viettel.mocha.database.model.SearchQuery { *; }


# google play service
-keep class * extends java.util.ListResourceBundle {
    protected Object[][] getContents();
}
-keep public class com.google.android.gms.common.internal.safeparcel.SafeParcelable {
    public static final *** NULL;
}
-keepnames @com.google.android.gms.common.annotation.KeepName class *
-keepclassmembernames class * {
    @com.google.android.gms.common.annotation.KeepName *;
}

# smack
-dontwarn org.jivesoftware.**
-keepclasseswithmembers class de.measite.smack.** { *; }
-keepclasseswithmembers class * extends org.jivesoftware.smack.sasl.SASLMechanism {
    public <init>(org.jivesoftware.smack.SASLAuthentication);
}
# httpcore, httpmine
-keepnames class org.apache.** {*;}
-keep public class org.apache.** {*;}
-dontwarn org.apache.http.**
#-dontwarn android.net.http.AndroidHttpClient

#-dontwarn org.apache.commons.**

-keep @com.facebook.common.internal.DoNotStrip class *
-keepclassmembers class * {
    @com.facebook.common.internal.DoNotStrip *;
}

# Keep native methods
-keepclassmembers class * {
    native <methods>;
}

-dontwarn okio.**
-dontwarn javax.annotation.**

-dontwarn zj.com.customize.sdk.**
-ignorewarnings