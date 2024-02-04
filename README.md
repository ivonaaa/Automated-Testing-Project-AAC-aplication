# Automated-Testing-Project-AAC-application

## Android project overview:

For the purpose of this project I have selected my Android Jetpack Compose
application SymbolSpeak-AAC. 

### Application overview
This is an Augmentative and Alternative Communication (AAC) app designed to assist users in expressing themselves using symbols. The app utilizes Firebase to store symbols, each with a unique ID, an image URL, and associated text. Users can select symbols from the library, which appear on the top of the screen. The selected symbols can be read aloud using text-to-speech functionality or deleted. Additionally, the app includes a screen for typing sentences that the app can read and delete, as well as an info page.

### Features
- **Symbol Selection:** Browse and select symbols from the Firebase library.
- **Text-to-Speech:** Read aloud selected symbols or user-typed sentences.
- **Symbol Deletion:** Remove symbols from the display as needed.
- **Sentence Input:** Type sentences for the app to read aloud.
- **Customise Settings** Customise colors, fonts size and tts rate
- **Info Page:** Access additional information about the app.


## Testing project overview: 
This repository contains tests for the AAC (Augmentative and Alternative Communication) app. The tests are written in Java and use Maven as the build tool.

### Prerequisites
- Java JDK installed
- Intellj IDE installed
- Maven installed
- AAC app source code available
- Appium installed
- Android Studio installed

### Test cases and descriptions:

#### 1. Select Symbol Test
- **Test Description:** Chooses one symbol and checks if it was selected.
- **Steps**:
1. Navigate to home screen
2. Select type of symbols "Most used"
3. Select one symbol of that type
4. Check if symbol appeared on chosen symbols view


#### 2. Delete Selected Symbol Test
- **Test Description:** Chooses one symbol and deletes it by clicking on the selected symbol.
- **Steps**:
1. Navigate to home screen
2. Select type of symbols "Most used"
3. Select one symbol of that type
4. Check if symbol appeared on chosen symbols view
5. Clicks on chosen symbol
6. Checks if symbol has been deleted

#### 3. Delete Symbol via Delete Button Test
- **Test Description:** Chooses one symbol and deletes it by clicking on the delete button.
- **Steps**:
1. Navigate to home screen
2. Select type of symbols "Most used"
3. Select one symbol of that type
4. Check if symbol appeared on chosen symbols view
5. Clicks on delete button
6. Checks if symbol has been deleted

#### 4. Input and Check Sentence Test
- **Test Description:** Inputs one sentence in custom sentences and checks if it is properly entered.
- **Steps**:
1. Navigate to custom sentences screen
2. Click on "+" button for adding sentences
3. Input sentence "Hello"
4. Check if sentence appeared on custom sentences screen

#### 5. Input, Delete Sentence Test
- **Test Description:** Inputs one sentence in custom sentences, deletes it, and checks if it was removed.
- **Steps**:
1. Navigate to custom sentences screen
2. Click on "+" button for adding sentences
3. Input sentence "Hello"
4. Check if sentence appeared on custom sentences screen
5. Click on delete button
6. Check if sentence was deleted

#### 6. Info Page Load Test
- **Test Description:** Checks if the info page loads successfully.
- **Steps**:
1. Navigate to info screen
2. Check if Text view was loaded
3. Compare is loaded text what it is suppost to say

### Running Tests
Before you run tests make sure to clone this repository to your computer.
To setup project you have to setup Appium, and Android emulator(this project uses Pixel 5 API 33).
Also change path to applications .apk by modiflying this line in TestMobileAACApp.java:
 ```bash
capabilities.setCapability("app", "{PATH_TO_CLONED_REPOSITORY}\\Automated-Testing-Project-AAC-aplication\\app-debug.apk");
 ```
To run the tests, use the following Maven command(ctrl+ENTER):
```bash
mvn test
 ```
 To check tests output navigate to:
  ```bash
{PATH_TO_CLONED_REPOSITORY}\Automated-Testing-Project-AAC-aplication\AutomatedAndroidAppTest\target\surefire-reports\"
 ```
 and click on ***index.html*** to see Test results.