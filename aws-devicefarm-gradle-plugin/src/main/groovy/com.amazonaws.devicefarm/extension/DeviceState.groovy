/*
 * Copyright 2015 the original author or authors.
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
package com.amazonaws.devicefarm.extension

import com.amazonaws.services.devicefarm.model.Location
import com.amazonaws.services.devicefarm.model.Radios

/**
 * DeviceState parameters
 */
class DeviceState {

    File extraDataZipFile
    List<File> auxiliaryApps = Collections.emptyList()
    def wifiOn = true;
    def bluetoothOn = true;
    def gpsOn = true;
    def nfcOn = true;

    def latitude = 47.6204;
    def longitude = -122.3491;

    def locale = Locale.US

    //These methods make the '=' optional when configuring the plugin
    void extraDataZipFile(File val) { extraDataZipFile = val }
    void auxiliaryApps(List<File> val) { auxiliaryApps = val }
    void wifi(RadioOnOff b) { wifiOn = b.bool }
    void bluetooth(RadioOnOff b) { bluetoothOn = b.bool }
    void gps(RadioOnOff b) { gpsOn = b.bool }
    void nfc(RadioOnOff b) { nfcOn = b.bool }
    void latitude(double d) { latitude = d }
    void longitude(double d) { longitude = d }

    Location getLocation() {

        def location = new Location();

        location.latitude = latitude;
        location.longitude = longitude;

        location;
    }

    Radios getRadios() {

        def radios = new Radios();

        radios.bluetooth = bluetoothOn;
        radios.gps = gpsOn;
        radios.nfc = nfcOn;
        radios.wifi = wifiOn;

        radios;

    }
}
