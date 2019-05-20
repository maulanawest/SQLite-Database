# SWLite-Database

### Priview
![Screen Shot 2019-05-20 at 23 16 52](https://user-images.githubusercontent.com/43386555/58036701-f424cd80-7b55-11e9-9ec5-996838929f84.png)

### Source
#### 1. MainActivity.java
    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

           try
           {

               //create database
               SQLiteDatabase eventsDB = this.openOrCreateDatabase("Events", MODE_PRIVATE, null);

               //create table
               eventsDB.execSQL("CREATE TABLE IF NOT EXISTS events (event VARCHAR, year INT(4))");

               //isi database
               eventsDB.execSQL("INSERT INTO events (event, year) VALUES ('Avengers', 2019)");

               eventsDB.execSQL("INSERT INTO events (event, year) VALUES ('Captain America', 2018)");

               //select query table database
               Cursor c = eventsDB.rawQuery("SELECT * FROM events", null);

               int eventIndext = c.getColumnIndex("event");
               int yearIndext = c.getColumnIndex("year");

               c.moveToFirst();

               while (c != null)
               {
                   Log.i("Result - event", c.getString(eventIndext));
                   Log.i("Result - age", Integer.toString(c.getInt(yearIndext)));

                   c.moveToNext();
               }

           }
           catch (Exception e)
           {
               e.printStackTrace();
           }
        }
