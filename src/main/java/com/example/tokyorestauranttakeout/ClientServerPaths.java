package com.example.tokyorestauranttakeout;

/**
 * クライアント画面パス
 */
public class ClientServerPaths {
    /**
     * 管理画面ルートパス
     */
    public final static String ROOT = "/client";

    /**
     * アカウント画面パス
     */
    public final static String ACCOUNT = ROOT + "/accounts";

    /**
     * アカウント画面パス
     */
    public final static String AUTH = ROOT + "/auth";

    /**
     * 公開パス
     */
    public final static String PUB = ROOT + "/pub";

    /**
     * 問い合わせ画面パス
     */
    public final static String QUESTION = PUB + "/questions";

    /**
     * 飲食店画面パス
     */
    public final static String RESTAURANT = PUB + "/restaurants";

    /**
     * 区内エリア画面パス
     */
    public final static String WARD_AREA = PUB + "/wardarea";

}
