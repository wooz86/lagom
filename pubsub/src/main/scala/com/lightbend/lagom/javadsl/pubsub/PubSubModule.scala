/*
 * Copyright (C) 2016 Lightbend Inc. <http://www.lightbend.com>
 */
package com.lightbend.lagom.javadsl.pubsub

import com.google.inject.AbstractModule
import com.lightbend.lagom.internal.pubsub.PubSubRegistryImpl

/**
 * Guice module for the PubSub API.
 */
class PubSubModule extends AbstractModule {

  override def configure(): Unit = {
    // eagerSingleton because the distributed registry benefits from being alive as early as possible.
    binder.bind(classOf[PubSubRegistry]).to(classOf[PubSubRegistryImpl]).asEagerSingleton()
  }

}
