package com.core.client;

import com.core.Controller;
import com.core.data.ServiceFile;
import com.core.data.WlanConfig;
import com.core.data.*;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ICoreClient {
    void setConnection(String address, int port);

    boolean isLocalConnection();

    Integer currentSession();

    boolean startThroughput(Controller controller) throws IOException;

    boolean stopThroughput() throws IOException;

    void updateSession(Integer sessionId);

    void updateState(SessionState state);

    SessionOverview createSession() throws IOException;

    boolean deleteSession(Integer sessionId) throws IOException;

    List<SessionOverview> getSessions() throws IOException;

    Session getSession(Integer sessionId) throws IOException;

    boolean start(Collection<CoreNode> nodes, Collection<CoreLink> links, List<Hook> hooks) throws IOException;

    boolean stop() throws IOException;

    boolean setState(SessionState state) throws IOException;

    Map<String, List<String>> getServices() throws IOException;

    Map<String, List<String>> getDefaultServices() throws IOException;

    boolean setDefaultServices(Map<String, Set<String>> defaults) throws IOException;

    CoreService getService(CoreNode node, String serviceName) throws IOException;

    boolean setService(CoreNode node, String serviceName, CoreService service) throws IOException;

    String getServiceFile(CoreNode node, String serviceName, String fileName) throws IOException;

    boolean startService(CoreNode node, String serviceName) throws IOException;

    boolean stopService(CoreNode node, String serviceName) throws IOException;

    boolean restartService(CoreNode node, String serviceName) throws IOException;

    boolean validateService(CoreNode node, String serviceName) throws IOException;

    boolean setServiceFile(CoreNode node, String serviceName, ServiceFile serviceFile) throws IOException;

    List<ConfigGroup> getEmaneConfig(CoreNode node) throws IOException;

    List<String> getEmaneModels() throws IOException;

    boolean setEmaneConfig(CoreNode node, List<ConfigOption> options) throws IOException;

    List<ConfigGroup> getEmaneModelConfig(Integer id, String model) throws IOException;

    boolean setEmaneModelConfig(Integer id, String model, List<ConfigOption> options) throws IOException;

    boolean isRunning();

    void saveSession(File file) throws IOException;

    SessionOverview openSession(File file) throws IOException;

    List<ConfigGroup> getSessionConfig() throws IOException;

    boolean setSessionConfig(List<ConfigOption> configOptions) throws IOException;

    boolean createNode(CoreNode node) throws IOException;

    String nodeCommand(CoreNode node, String command) throws IOException;

    boolean editNode(CoreNode node) throws IOException;

    boolean deleteNode(CoreNode node) throws IOException;

    boolean createLink(CoreLink link) throws IOException;

    boolean editLink(CoreLink link) throws IOException;

    boolean createHook(Hook hook) throws IOException;

    List<Hook> getHooks() throws IOException;

    WlanConfig getWlanConfig(CoreNode node) throws IOException;

    boolean setWlanConfig(CoreNode node, WlanConfig config) throws IOException;

    String getTerminalCommand(CoreNode node) throws IOException;

    Map<Integer, MobilityConfig> getMobilityConfigs() throws IOException;

    boolean setMobilityConfig(CoreNode node, MobilityConfig config) throws IOException;

    MobilityConfig getMobilityConfig(CoreNode node) throws IOException;

    boolean mobilityAction(CoreNode node, String action) throws IOException;

    LocationConfig getLocationConfig() throws IOException;

    boolean setLocationConfig(LocationConfig config) throws IOException;

    void setupEventHandlers(Controller controller) throws IOException;
}
