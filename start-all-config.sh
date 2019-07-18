java -jar selenium-server-standalone-3.1.0.jar -role hub -browserTimeout 0 -timeout 1800 &
cd resources/nodes-config
appium --nodeconfig Pixel_3_API_28_Android_9.0.json -p 5001 -bp 5554 -U emulator-5554 &
appium --nodeconfig iPhone-7_iOS-12.2.json -p 5002 -U E52560B2-59DD-4167-80FB-055CA21C7215 &
#cd ~/Library/Android/sdk/tools/
#./emulator -avd "Pixel_3_API_28_Android_9.0" &
