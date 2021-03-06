/*
 * Copyright 2011 JBoss, by Red Hat, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.errai.common.client.util;

import com.google.gwt.core.client.GWT;

/**
 * @author Mike Brock
 */
public final class LogUtil {
  private LogUtil() {
  }

  public static void log(final String message) {
    if (GWT.isClient() && isNativeJavaScriptLoggerSupported()) {
      nativeLog("[errai] " + message);
    }
    else {
      System.out.println("[errai] " + message);
    }
  }

  public static native boolean isNativeJavaScriptLoggerSupported() /*-{
    return ((window.console != null) &&
            (window.console.firebug == null) &&
            (window.console.log != null) &&
            (typeof(window.console.log) == 'function'));
  }-*/;

  public static native void nativeLog(String message) /*-{
    window.console.log(message);
  }-*/;

  public static void displaySeparator() {
    nativeLog("------------------------------------------------");
  }

  public static void displayDebuggerUtilityTitle(final String title) {
    nativeLog(title);
    displaySeparator();
  }
}
