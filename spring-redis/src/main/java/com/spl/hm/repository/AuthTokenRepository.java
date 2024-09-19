package com.spl.hm.repository;

import java.util.Map;

public interface AuthTokenRepository {

    Map<String, String> getAuthToken(final String authId);

    void upsertAuthToken(final String authId, Map<String, String> authToken);

    void deleteAuthToken(final String authId);
}
