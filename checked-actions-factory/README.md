wildfly: setCheckedActionFactoryExample
=======================================
Author: Tom Jenkinson

Introduction
------------

This quickstart shows how you can use checked actions inside the WildFly container


Running the Quickstart
----------------------

If you are using the "master" version of the quickstarts, you will need to build Narayana master locally (https://github.com/jbosstm/narayana/). When using a tagged version of the quickstarts the artifact should exist in JBoss nexus (or maven central).

You will also need the current version of WildFly to run this quickstart. WildFly is available from http://wildfly.org/downloads/

To run the example, type:

	mvn clean install
	mvn install -Pdeploy
	<WFLY_HOME>/bin/standalone.sh

The output will be similar to:

	14:22:19,938 INFO  [org.jboss.weld.deployer] (MSC service thread 1-3) WFLYWELD0003: Processing weld deployment checked-actions-factory-0.0.1-SNAPSHOT.war
	14:22:19,956 INFO  [org.jboss.as.ejb3.deployment] (MSC service thread 1-3) WFLYEJB0473: JNDI bindings for session bean named 'MyEJB' in deployment unit 'deployment "checked-actions-factory-0.0.1-SNAPSHOT.war"' are as follows:

		java:global/checked-actions-factory-0.0.1-SNAPSHOT/MyEJB!org.narayana.handler.MyEJB
		java:app/checked-actions-factory-0.0.1-SNAPSHOT/MyEJB!org.narayana.handler.MyEJB
		java:module/MyEJB!org.narayana.handler.MyEJB
		java:global/checked-actions-factory-0.0.1-SNAPSHOT/MyEJB
		java:app/checked-actions-factory-0.0.1-SNAPSHOT/MyEJB
		java:module/MyEJB

	14:22:19,960 INFO  [org.jboss.as.ejb3.deployment] (MSC service thread 1-3) WFLYEJB0473: JNDI bindings for session bean named 'StartupBean' in deployment unit 'deployment "checked-actions-factory-0.0.1-SNAPSHOT.war"' are as follows:

		java:global/checked-actions-factory-0.0.1-SNAPSHOT/StartupBean!org.narayana.StartupBean
		java:app/checked-actions-factory-0.0.1-SNAPSHOT/StartupBean!org.narayana.StartupBean
		java:module/StartupBean!org.narayana.StartupBean
		java:global/checked-actions-factory-0.0.1-SNAPSHOT/StartupBean
		java:app/checked-actions-factory-0.0.1-SNAPSHOT/StartupBean
		java:module/StartupBean

	14:22:20,290 INFO  [stdout] (ServerService Thread Pool -- 87) StartupBean call
	14:22:20,292 INFO  [stdout] (ServerService Thread Pool -- 87) MyEJB call
	14:22:20,292 WARN  [com.arjuna.ats.arjuna] (ServerService Thread Pool -- 87) ARJUNA012094: Commit of action id 0:ffff7f000101:-4677a4cb:5983138d:32 invoked while multiple threads active within it.
	14:22:20,293 WARN  [com.arjuna.ats.arjuna] (ServerService Thread Pool -- 87) ARJUNA012107: CheckedAction::check - atomic action 0:ffff7f000101:-4677a4cb:5983138d:32 commiting with 2 threads active!

To undeploy the example run :

    mvn clean -Pdeploy

Understanding the Code
----------------------

To understand the code and the checked action API, it is recommended that you:

1. Browse the code reading the comments
2. Read the following document: http://narayana.io/docs/product/index.html#d0e2528
