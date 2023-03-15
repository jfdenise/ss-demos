ARG IMAGE_VERSION=latest

FROM registry.redhat.io/jboss-eap-8-tech-preview/eap8-openjdk17-builder-openshift-rhel8:$IMAGE_VERSION
ARG MAVEN_OPTS
ENV MAVEN_OPTS=$MAVEN_OPTS
ARG MAVEN_ARGS_APPEND
ENV MAVEN_ARGS_APPEND=$MAVEN_ARGS_APPEND
ARG MAVEN_S2I_ARTIFACT_DIRS=target
ENV MAVEN_S2I_ARTIFACT_DIRS=$MAVEN_S2I_ARTIFACT_DIRS

WORKDIR /build
RUN mkdir src
COPY --chown=jboss:root . ./src
ENV S2I_DESTINATION_DIR=/build
RUN /usr/local/s2i/assemble
# Not yet possible with Beta
#RUN mv "$JBOSS_HOME/standalone/deployments" "/build/jboss-ext-deployments"

FROM registry.redhat.io/jboss-eap-8-tech-preview/eap8-openjdk17-runtime-openshift-rhel8:$IMAGE_VERSION
COPY --from=0 --chown=jboss:root $JBOSS_HOME $JBOSS_HOME
# Not yet possible with Beta
#COPY --from=0 --chown=jboss:root /build/jboss-ext-deployments $JBOSS_HOME/standalone/deployments
RUN chmod -R ug+rwX $JBOSS_HOME
