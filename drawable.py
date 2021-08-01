import os
folder = os.listdir('app/src/main/assets')
print(folder)

str_counter = """<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android='http://schemas.android.com/apk/res/android'
android:layout_width='match_parent'
android:layout_height='match_parent'
android:orientation='vertical'
style = "?layerOneBG"
>

    <ScrollView
    android:layout_width="fill_parent"  
    android:layout_height="0dp"  
    android:padding = "10dp"
    android:layout_weight = "9"
    style = "?layerOneBG"
    android:id="@+id/scrollView"
    android:scrollbarThumbVertical="@null"
    >  



        
        <LinearLayout xmlns:android='http://schemas.android.com/apk/res/android'
        android:layout_width='match_parent'
        android:layout_height='match_parent'
        android:orientation='vertical'
        style = "?layerOneBG"
        >     

"""
global_path = ""

for item in folder:
    
    print(item)
    if ".json" in item:
        print("another function needed")
        chapter = item.replace("-" ," ")
        chapter = chapter.replace(".json","")
        str_counter = str_counter + f"""
            <TextView
                    android:layout_width='wrap_content'
                    android:layout_height='wrap_content'
                    android:layout_marginBottom='10dp'
                    android:text='mcq from {chapter} '
                    style = "?headlineText"
                    android:textSize='16dp'
                    />
            <HorizontalScrollView  
                android:layout_width="match_parent"  
                android:layout_height="wrap_content"  
                android:id="@+id/horizontalScrollView"
                style = "?layerOneBG"
                android:scrollbarThumbHorizontal="@null"
                >  
                            
                    <LinearLayout  
                    android:layout_width="wrap_content"  
                    android:layout_height="140dp"  
                    android:orientation="horizontal"
                    style = "?layerOneBG"
                    >  
                        <TextView
                            android:layout_width='335dp'
                            android:layout_height='fill_parent'
                            style = "?cbutton"
                            android:layout_marginBottom='10dp'
                            android:text='{chapter}'
                          
                            android:textSize='15dp'
                            android:textStyle='bold'
                            android:gravity = 'center'
                            android:layout_margin = "2dp"
                            android:tag="{item}"
                            android:onClick="clickButton"
                            />

                    </LinearLayout>  
            </HorizontalScrollView>
        """

    else:
        files = os.listdir(f'app/src/main/assets/{item}')
        global_path = f'{item}'
    
        subject_name = f"""
               <TextView
                android:layout_width='wrap_content'
                android:layout_height='wrap_content'
                android:layout_marginBottom='10dp'
                android:text='mcq from {item} '
                style = "?headlineText"
                android:textSize='16dp'
                />
        """
    
        layout_name = """
                <HorizontalScrollView  
                android:layout_width="match_parent"  
                android:layout_height="wrap_content"  
                android:id="@+id/horizontalScrollView"
                style = "?layerOneBG"
                android:scrollbarThumbHorizontal="@null"
                >  
                            
                    <LinearLayout  
                    android:layout_width="wrap_content"  
                    android:layout_height="140dp"  
                    android:orientation="horizontal"
                    style = "?layerOneBG"
                    >  
        """
        str_counter = str_counter+ subject_name
        str_counter = str_counter + layout_name
        for item in files:
            print(item)
            chapter = item.replace("-" ," ")
            chapter = chapter.replace(".json","")
            chapter_name = f"""
                        <TextView
                        android:layout_width='110dp'
                        android:layout_height='fill_parent'
                        style = "?cbutton"
                        android:layout_marginBottom='10dp'
                        android:text='{chapter}'
                      
                        android:textSize='15dp'
                        android:textStyle='bold'
                        android:gravity = 'center'
                        android:layout_margin = "2dp"
                        android:tag="{global_path}/{item}"
                        android:onClick="clickButton"
                        />
            """
    
            str_counter = str_counter+chapter_name
        str_counter = str_counter + """
                    </LinearLayout>  
                </HorizontalScrollView>
    
    

    """


str_counter = str_counter + """

        </LinearLayout>     
    </ScrollView>



    <LinearLayout xmlns:android='http://schemas.android.com/apk/res/android'
    android:layout_width='match_parent'
    android:layout_height='0dp'
    android:orientation='horizontal'
    android:layout_weight = "1"
    android:gravity="center"
    style = "?cbutton"
    >
                
        <ImageView
         android:layout_width="36dp"
         android:layout_height="36dp"
         android:layout_margin = "5dp"
         android:src="@drawable/theme_icon"
         android:onClick = "colorthemeChange"
         style = "?iconc"
         
         /> 

    </LinearLayout>

</LinearLayout>
"""

print(str_counter)


with open('sample.txt' , 'w') as f:
    f.write(str_counter)



