## lecture #1:

#### Programs to install:
* [intellij idea](https://www.jetbrains.com/idea/download/)
* [Firefox](https://www.mozilla.org/ru/firefox/download/)
* [JDK 10](http://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html)

#### Configuration for new project:
1. Install intellij idea, Firefox, JDK and GIT just pressing NEXT button  
2. Check for JAVA in your environment - Open Command Prompt and 
type: "java -version" (If nothing displayed you need to add java PATCH(Described in the "features/issues"))
3. Create new project, select correct JDK version (You can add JDK folder manual if nothing displayed) 

 ####  installation features/issues:
1. Download [geckodriver](https://github.com/mozilla/geckodriver/releases) unarchive and copy to ~/Windows/System32/  
2. JDK not found:

* Press "Windows Key" + "R" at the same time to get command prompt. Then type sysdm.cpl, go to advanced and select Environmental Variables

* Add PATCH to JAVA JDK Directory


![](https://i.stack.imgur.com/TM3tFl.png)
 
## lecture #2:

#### Git configuration and installation:

* [GIT](https://git-scm.com/downloads)
* [Project link (Github repository)](https://github.com/krosskain/qaauto-20.04.2018.git)


#### Alternative search:
for (int i=0;i<searchresults.size();i++){if (searchresults.get(i).getText().contains(searchName)){System.out.println(searchresults.get(i).getText());System.out.println("-----");searchCounter++;}