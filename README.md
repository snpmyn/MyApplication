<div align=center><img src="https://github.com/snpmyn/Push/raw/master/image.png"/></div>

[![SNAPSHOT](https://jitpack.io/v/Jaouan/Revealator.svg)](https://jitpack.io/#snpmyn/MyApplication)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/55524606732f4c4fb9f5e207c412a3a7)](https://www.codacy.com/manual/snpmyn/MyApplication?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=snpmyn/Push&amp;utm_campaign=Badge_Grade)
[![GitHub license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](https://www.apache.org/licenses/LICENSE-2.0)
[![API](https://img.shields.io/badge/API-19%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=19)

[![GitHub stars](https://img.shields.io/github/stars/Bigkoo/MyApplication.svg?style=social)](https://github.com/Bigkoo/MyApplication/stargazers)
[![GitHub forks](https://img.shields.io/github/forks/Bigkoo/MyApplication.svg?style=social)](https://github.com/Bigkoo/MyApplication/network)
[![GitHub watchers](https://img.shields.io/github/watchers/Bigkoo/MyApplication.svg?style=social)](https://github.com/Bigkoo/MyApplication/watchers)

### 介绍
日常练习。

### 架构
| 模块 | 说明 | 补充 |
|:-:|:-:|:-:|
| 示例app | 用法举例 | 无 |
| 一方库fairy | 推送集成实现 | 无 |

### 依赖、权限
| 模块 | 依赖 |
|:-:|:-:|
| 示例app | implementation project(path: ':fairy') |
| 一方库fairy | implementation 'com.squareup.okio:okio:2.9.0' |
| 一方库fairy | api 'androidx.recyclerview:recyclerview:1.1.0'（避重）|

| 模块 | 权限 |
|:-:|:-:|
| 示例app | 无 |
| 一方库fairy | 略 |

### 使用
> [SECURITY](https://github.com/snpmyn/MyApplication/blob/master/SECURITY.md)<br>
> 版本快速迭代中，拉取失败暂时查看源码。

build.gradle(module)
```
// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {  
    repositories {
        google()
        jcenter()
        
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:4.1.1'            

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }  
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}
```
build.gradle(app)
```
apply plugin: 'com.android.application'

android {
    ...
    defaultConfig {
        ...      
    }       
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
    configurations.all {
        resolutionStrategy.cacheChangingModulesFor 0, 'seconds'
    }
}

dependencies {
    implementation 'com.github.snpmyn.MyApplication:fairy:v0.0.1.1X'
}
```

### License
```
Copyright 2019 snpmyn

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
