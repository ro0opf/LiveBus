# LiveBus
Make it easy to pass data between activity and activity

Usage
--------

**STEP 1**

Add dependency to your gradle file:
```groovy
compile 'ro0opf.lifeinus:livebus:0.0.1-alpha01'
```

**STEP 2**

``` java
public class AnyActivity extends AppCompatActivity {
    ...
    LiveBus liveBus = LiveBus.getInstance();
    
    void function() {
        ...
        liveBus.sendBus(KEY, OBJECT);
        ...
    }
    ...
}
```

``` java
public class MainActivity extends AppCompatActivity {
    ...
    LiveBus liveBus = LiveBus.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ...
        liveBus.getBus(KEY).observe(this, o -> {
            // do something
        });
        ...
    }
    ...
}
```


License
--------

    Copyright 2019 ro0opf, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
