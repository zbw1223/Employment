package com.example.recriutingsystem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySQLiteHelper extends SQLiteOpenHelper {

    public MySQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE [dbo].[business](\n" +
                "\t[uid] [int] NOT NULL,\n" +
                "\t[businessName] nchar(18),\n" +
                "\t[city] [nchar](18),\n" +
                "\t[email] [varchar](30),\n" +
                "\t[introduce] [ntext],\n" +
                " CONSTRAINT [PK_business] PRIMARY KEY" +
                "(\n" +
                "\t[uid] ASC\n" +
                ")WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]\n" +
                ") ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]\n" +
                "GO\n" +
                "ALTER TABLE [dbo].[business]  WITH CHECK ADD  CONSTRAINT [FK_business_users] FOREIGN KEY([uid])\n" +
                "REFERENCES [dbo].[users] ([uid])\n" +
                "GO\n" +
                "ALTER TABLE [dbo].[business] CHECK CONSTRAINT [FK_business_users]\n" +
                "GO\n");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
