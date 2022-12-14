/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.view;

import static android.view.Display.INVALID_DISPLAY;

import android.annotation.IntDef;
import android.annotation.NonNull;
import android.annotation.Nullable;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

import com.android.internal.annotations.VisibleForTesting;
import com.android.internal.util.DataClass;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Description of a content recording session.
 *
 * @hide
 */
@DataClass(
        genConstructor = false,
        genToString = true,
        genSetters = true,
        genEqualsHashCode = true
)
public final class ContentRecordingSession implements Parcelable {

    /**
     * An entire DisplayContent is being recorded. Recording may also be paused.
     */
    public static final int RECORD_CONTENT_DISPLAY = 0;
    /**
     * A single Task is being recorded. Recording may also be paused.
     */
    public static final int RECORD_CONTENT_TASK = 1;

    /**
     * Unique logical identifier of the {@link android.hardware.display.VirtualDisplay} that has
     * recorded content rendered to its surface.
     */
    private int mDisplayId = INVALID_DISPLAY;

    /**
     * The content to record.
     */
    @RecordContent
    private int mContentToRecord = RECORD_CONTENT_DISPLAY;

    /**
     * The token of the layer of the hierarchy to record.
     * If {@link #getContentToRecord()} is @link RecordContent#RECORD_CONTENT_DISPLAY}, then
     * represents the WindowToken corresponding to the DisplayContent to record.
     * If {@link #getContentToRecord()} is {@link RecordContent#RECORD_CONTENT_TASK}, then
     * represents the {@link android.window.WindowContainerToken} of the Task to record.
     */
    @VisibleForTesting
    @Nullable
    private IBinder mTokenToRecord = null;

    /**
     * Default instance, with recording the display.
     */
    private ContentRecordingSession() {
    }

    /**
     * Returns an instance initialized for display recording.
     */
    public static ContentRecordingSession createDisplaySession(
            @NonNull IBinder displayContentWindowToken) {
        return new ContentRecordingSession().setContentToRecord(RECORD_CONTENT_DISPLAY)
                .setTokenToRecord(displayContentWindowToken);
    }

    /**
     * Returns an instance initialized for task recording.
     */
    public static ContentRecordingSession createTaskSession(
            @NonNull IBinder taskWindowContainerToken) {
        return new ContentRecordingSession().setContentToRecord(RECORD_CONTENT_TASK)
                .setTokenToRecord(taskWindowContainerToken);
    }

    /**
     * Returns {@code true} if this is a valid session.
     */
    public static boolean isValid(ContentRecordingSession session) {
        return session != null && (session.getDisplayId() > INVALID_DISPLAY
                && session.getTokenToRecord() != null);
    }

    /**
     * Returns {@code true} when both sessions are for the same display.
     */
    public static boolean isSameDisplay(ContentRecordingSession session,
            ContentRecordingSession incomingSession) {
        return session != null && incomingSession != null
                && session.getDisplayId() == incomingSession.getDisplayId();
    }




    // Code below generated by codegen v1.0.23.
    //
    // DO NOT MODIFY!
    // CHECKSTYLE:OFF Generated code
    //
    // To regenerate run:
    // $ codegen $ANDROID_BUILD_TOP/frameworks/base/core/java/android/view/ContentRecordingSession.java
    //
    // To exclude the generated code from IntelliJ auto-formatting enable (one-time):
    //   Settings > Editor > Code Style > Formatter Control
    //@formatter:off


    @IntDef(prefix = "RECORD_CONTENT_", value = {
        RECORD_CONTENT_DISPLAY,
        RECORD_CONTENT_TASK
    })
    @Retention(RetentionPolicy.SOURCE)
    @DataClass.Generated.Member
    public @interface RecordContent {}

    @DataClass.Generated.Member
    public static String recordContentToString(@RecordContent int value) {
        switch (value) {
            case RECORD_CONTENT_DISPLAY:
                    return "RECORD_CONTENT_DISPLAY";
            case RECORD_CONTENT_TASK:
                    return "RECORD_CONTENT_TASK";
            default: return Integer.toHexString(value);
        }
    }

    @DataClass.Generated.Member
    /* package-private */ ContentRecordingSession(
            int displayId,
            @RecordContent int contentToRecord,
            @VisibleForTesting @Nullable IBinder tokenToRecord) {
        this.mDisplayId = displayId;
        this.mContentToRecord = contentToRecord;

        if (!(mContentToRecord == RECORD_CONTENT_DISPLAY)
                && !(mContentToRecord == RECORD_CONTENT_TASK)) {
            throw new java.lang.IllegalArgumentException(
                    "contentToRecord was " + mContentToRecord + " but must be one of: "
                            + "RECORD_CONTENT_DISPLAY(" + RECORD_CONTENT_DISPLAY + "), "
                            + "RECORD_CONTENT_TASK(" + RECORD_CONTENT_TASK + ")");
        }

        this.mTokenToRecord = tokenToRecord;
        com.android.internal.util.AnnotationValidations.validate(
                VisibleForTesting.class, null, mTokenToRecord);

        // onConstructed(); // You can define this method to get a callback
    }

    /**
     * Unique logical identifier of the {@link android.hardware.display.VirtualDisplay} that has
     * recorded content rendered to its surface.
     */
    @DataClass.Generated.Member
    public int getDisplayId() {
        return mDisplayId;
    }

    /**
     * The content to record.
     */
    @DataClass.Generated.Member
    public @RecordContent int getContentToRecord() {
        return mContentToRecord;
    }

    /**
     * {The token of the layer of the hierarchy to record.
     * If {@link #getContentToRecord()} is @link RecordContent#RECORD_CONTENT_DISPLAY}, then
     * represents the WindowToken corresponding to the DisplayContent to record.
     * If {@link #getContentToRecord()} is {@link RecordContent#RECORD_CONTENT_TASK}, then
     * represents the {@link android.window.WindowContainerToken} of the Task to record.
     */
    @DataClass.Generated.Member
    public @VisibleForTesting @Nullable IBinder getTokenToRecord() {
        return mTokenToRecord;
    }

    /**
     * Unique logical identifier of the {@link android.hardware.display.VirtualDisplay} that has
     * recorded content rendered to its surface.
     */
    @DataClass.Generated.Member
    public @NonNull ContentRecordingSession setDisplayId( int value) {
        mDisplayId = value;
        return this;
    }

    /**
     * The content to record.
     */
    @DataClass.Generated.Member
    public @NonNull ContentRecordingSession setContentToRecord(@RecordContent int value) {
        mContentToRecord = value;

        if (!(mContentToRecord == RECORD_CONTENT_DISPLAY)
                && !(mContentToRecord == RECORD_CONTENT_TASK)) {
            throw new java.lang.IllegalArgumentException(
                    "contentToRecord was " + mContentToRecord + " but must be one of: "
                            + "RECORD_CONTENT_DISPLAY(" + RECORD_CONTENT_DISPLAY + "), "
                            + "RECORD_CONTENT_TASK(" + RECORD_CONTENT_TASK + ")");
        }

        return this;
    }

    /**
     * {The token of the layer of the hierarchy to record.
     * If {@link #getContentToRecord()} is @link RecordContent#RECORD_CONTENT_DISPLAY}, then
     * represents the WindowToken corresponding to the DisplayContent to record.
     * If {@link #getContentToRecord()} is {@link RecordContent#RECORD_CONTENT_TASK}, then
     * represents the {@link android.window.WindowContainerToken} of the Task to record.
     */
    @DataClass.Generated.Member
    public @NonNull ContentRecordingSession setTokenToRecord(@VisibleForTesting @NonNull IBinder value) {
        mTokenToRecord = value;
        com.android.internal.util.AnnotationValidations.validate(
                VisibleForTesting.class, null, mTokenToRecord);
        return this;
    }

    @Override
    @DataClass.Generated.Member
    public String toString() {
        // You can override field toString logic by defining methods like:
        // String fieldNameToString() { ... }

        return "ContentRecordingSession { " +
                "displayId = " + mDisplayId + ", " +
                "contentToRecord = " + recordContentToString(mContentToRecord) + ", " +
                "tokenToRecord = " + mTokenToRecord +
        " }";
    }

    @Override
    @DataClass.Generated.Member
    public boolean equals(@Nullable Object o) {
        // You can override field equality logic by defining either of the methods like:
        // boolean fieldNameEquals(ContentRecordingSession other) { ... }
        // boolean fieldNameEquals(FieldType otherValue) { ... }

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        @SuppressWarnings("unchecked")
        ContentRecordingSession that = (ContentRecordingSession) o;
        //noinspection PointlessBooleanExpression
        return true
                && mDisplayId == that.mDisplayId
                && mContentToRecord == that.mContentToRecord
                && java.util.Objects.equals(mTokenToRecord, that.mTokenToRecord);
    }

    @Override
    @DataClass.Generated.Member
    public int hashCode() {
        // You can override field hashCode logic by defining methods like:
        // int fieldNameHashCode() { ... }

        int _hash = 1;
        _hash = 31 * _hash + mDisplayId;
        _hash = 31 * _hash + mContentToRecord;
        _hash = 31 * _hash + java.util.Objects.hashCode(mTokenToRecord);
        return _hash;
    }

    @Override
    @DataClass.Generated.Member
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        // You can override field parcelling by defining methods like:
        // void parcelFieldName(Parcel dest, int flags) { ... }

        byte flg = 0;
        if (mTokenToRecord != null) flg |= 0x4;
        dest.writeByte(flg);
        dest.writeInt(mDisplayId);
        dest.writeInt(mContentToRecord);
        if (mTokenToRecord != null) dest.writeStrongBinder(mTokenToRecord);
    }

    @Override
    @DataClass.Generated.Member
    public int describeContents() { return 0; }

    /** @hide */
    @SuppressWarnings({"unchecked", "RedundantCast"})
    @DataClass.Generated.Member
    /* package-private */ ContentRecordingSession(@NonNull Parcel in) {
        // You can override field unparcelling by defining methods like:
        // static FieldType unparcelFieldName(Parcel in) { ... }

        byte flg = in.readByte();
        int displayId = in.readInt();
        int contentToRecord = in.readInt();
        IBinder tokenToRecord = (flg & 0x4) == 0 ? null : (IBinder) in.readStrongBinder();

        this.mDisplayId = displayId;
        this.mContentToRecord = contentToRecord;

        if (!(mContentToRecord == RECORD_CONTENT_DISPLAY)
                && !(mContentToRecord == RECORD_CONTENT_TASK)) {
            throw new java.lang.IllegalArgumentException(
                    "contentToRecord was " + mContentToRecord + " but must be one of: "
                            + "RECORD_CONTENT_DISPLAY(" + RECORD_CONTENT_DISPLAY + "), "
                            + "RECORD_CONTENT_TASK(" + RECORD_CONTENT_TASK + ")");
        }

        this.mTokenToRecord = tokenToRecord;
        com.android.internal.util.AnnotationValidations.validate(
                VisibleForTesting.class, null, mTokenToRecord);

        // onConstructed(); // You can define this method to get a callback
    }

    @DataClass.Generated.Member
    public static final @NonNull Parcelable.Creator<ContentRecordingSession> CREATOR
            = new Parcelable.Creator<ContentRecordingSession>() {
        @Override
        public ContentRecordingSession[] newArray(int size) {
            return new ContentRecordingSession[size];
        }

        @Override
        public ContentRecordingSession createFromParcel(@NonNull Parcel in) {
            return new ContentRecordingSession(in);
        }
    };

    /**
     * A builder for {@link ContentRecordingSession}
     */
    @SuppressWarnings("WeakerAccess")
    @DataClass.Generated.Member
    public static final class Builder {

        private int mDisplayId;
        private @RecordContent int mContentToRecord;
        private @VisibleForTesting @Nullable IBinder mTokenToRecord;

        private long mBuilderFieldsSet = 0L;

        public Builder() {
        }

        /**
         * Unique logical identifier of the {@link android.hardware.display.VirtualDisplay} that has
         * recorded content rendered to its surface.
         */
        @DataClass.Generated.Member
        public @NonNull Builder setDisplayId(int value) {
            checkNotUsed();
            mBuilderFieldsSet |= 0x1;
            mDisplayId = value;
            return this;
        }

        /**
         * The content to record.
         */
        @DataClass.Generated.Member
        public @NonNull Builder setContentToRecord(@RecordContent int value) {
            checkNotUsed();
            mBuilderFieldsSet |= 0x2;
            mContentToRecord = value;
            return this;
        }

        /**
         * {The token of the layer of the hierarchy to record.
         * If {@link #getContentToRecord()} is @link RecordContent#RECORD_CONTENT_DISPLAY}, then
         * represents the WindowToken corresponding to the DisplayContent to record.
         * If {@link #getContentToRecord()} is {@link RecordContent#RECORD_CONTENT_TASK}, then
         * represents the {@link android.window.WindowContainerToken} of the Task to record.
         */
        @DataClass.Generated.Member
        public @NonNull Builder setTokenToRecord(@VisibleForTesting @NonNull IBinder value) {
            checkNotUsed();
            mBuilderFieldsSet |= 0x4;
            mTokenToRecord = value;
            return this;
        }

        /** Builds the instance. This builder should not be touched after calling this! */
        public @NonNull ContentRecordingSession build() {
            checkNotUsed();
            mBuilderFieldsSet |= 0x8; // Mark builder used

            if ((mBuilderFieldsSet & 0x1) == 0) {
                mDisplayId = INVALID_DISPLAY;
            }
            if ((mBuilderFieldsSet & 0x2) == 0) {
                mContentToRecord = RECORD_CONTENT_DISPLAY;
            }
            if ((mBuilderFieldsSet & 0x4) == 0) {
                mTokenToRecord = null;
            }
            ContentRecordingSession o = new ContentRecordingSession(
                    mDisplayId,
                    mContentToRecord,
                    mTokenToRecord);
            return o;
        }

        private void checkNotUsed() {
            if ((mBuilderFieldsSet & 0x8) != 0) {
                throw new IllegalStateException(
                        "This Builder should not be reused. Use a new Builder instance instead");
            }
        }
    }

    @DataClass.Generated(
            time = 1645803878639L,
            codegenVersion = "1.0.23",
            sourceFile = "frameworks/base/core/java/android/view/ContentRecordingSession.java",
            inputSignatures = "public static final  int RECORD_CONTENT_DISPLAY\npublic static final  int RECORD_CONTENT_TASK\nprivate  int mDisplayId\nprivate @android.view.ContentRecordingSession.RecordContent int mContentToRecord\nprivate @com.android.internal.annotations.VisibleForTesting @android.annotation.Nullable android.os.IBinder mTokenToRecord\npublic static  android.view.ContentRecordingSession createDisplaySession(android.os.IBinder)\npublic static  android.view.ContentRecordingSession createTaskSession(android.os.IBinder)\npublic static  boolean isValid(android.view.ContentRecordingSession)\npublic static  boolean isSameDisplay(android.view.ContentRecordingSession,android.view.ContentRecordingSession)\nclass ContentRecordingSession extends java.lang.Object implements [android.os.Parcelable]\n@com.android.internal.util.DataClass(genConstructor=false, genToString=true, genSetters=true, genEqualsHashCode=true)")
    @Deprecated
    private void __metadata() {}


    //@formatter:on
    // End of generated code

}
