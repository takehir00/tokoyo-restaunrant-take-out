package com.example.tokyorestauranttakeout.security;

/**
 * セキュリティの優先順位
 */
public class SecurityOrderConst {

    /**
     * 管理画面セキュリティ
     */
    public final static int ADMIN = 0;

    /**
     * クライアント画面セキュリティ
     */
    public final static int CLIENT = 1;

    /**
     * 認証不要パスセキュリティ
     */
    public final static int PUBLIC = 2;
}
