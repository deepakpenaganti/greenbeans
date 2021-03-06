/*******************************************************************************
 * Copyright (c) 2015, 2016 David Green.
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
 *******************************************************************************/
package com.greensopinion.finance.services.encryption;

import static com.greensopinion.finance.services.InjectorAsserts.assertSingletonBinding;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.greensopinion.finance.services.encryption.EncryptionModule;
import com.greensopinion.finance.services.encryption.EncryptorListener;
import com.greensopinion.finance.services.encryption.EncryptorProviderService;
import com.greensopinion.finance.services.encryption.EncryptorService;
import com.greensopinion.finance.services.encryption.MasterPasswordChangeSupport;

public class EncryptionModuleTest {
	@Test
	public void providesEncryptorProviderService() {
		assertSingletonBinding(createInjector(), EncryptorProviderService.class);
	}

	@Test
	public void providesEncryptorService() {
		assertSingletonBinding(createInjector(), EncryptorService.class);
	}

	@Test
	public void providesMasterPasswordChangeSupport() {
		assertSingletonBinding(createInjector(), EncryptorListener.class, MasterPasswordChangeSupport.class);
	}

	private Injector createInjector() {
		return Guice.createInjector(new EncryptionModule());
	}
}
