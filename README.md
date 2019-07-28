# IntentUsage
Learn using intents to send information from one activity to other used implicit and explicit intents



## Concepts dealt 

Intent are of two types **Explicit and Implicit**. 


* Implicit Intent doesn't specifiy the component. In such case, intent provides information of available components provided by the system that is to be invoked.
For example, you may write the following code to view the webpage.

```
Intent intent=new Intent(Intent.ACTION_VIEW);  
intent.setData(Uri.parse("http://www.javatpoint.com"));  
startActivity(intent);  
```


* Explicit Intent specifies the component. In such cases external class are invoked

```
Intent intent = new Intent(this,SecondActivity.class)

intent.putExtra("NAME","sai");
startActivity(intent) 
```



### Getting information from other Activities

We can send and retreive information from one activity to another. There are two methods to do this

- **startActivity(intent)** : This method doesn't expect any feedback from the other activity, used to send information from one activity to another
- **startActivityForResult(intent,REQUEST_CODE)** : This method expects a feedback from the other activity, mainly used with implicit intents, once the other activity ends **onActivityResult()** is called.  

**Example**: 

![MyImage1](https://www.vogella.com/tutorials/AndroidIntent/img/xstartactivity10.png.pagespeed.ic.Q8qzr6jDJN.png)
![MyImage](https://www.vogella.com/tutorials/AndroidIntent/img/xstartactivity20.png.pagespeed.ic.uk3zoX72OG.png)



## About this Project
    
    Simple project which uses both implicit and explicit intent. 
     
    
  
