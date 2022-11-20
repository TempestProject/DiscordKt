package guild

import kotlinx.serialization.Serializable
import user.User

@Serializable class GuildMember(
    val user: User? = null,
    val nick: String? = null,
    val avatar: String? = null,
    val roles: Array<String>,
    val joined_at: String,
    val premium_since: String? = null,
    val deaf: Boolean,
    val mute: Boolean,
    val pending: Boolean? = null,
    val permissions: String? = null,
    val communication_disabled_until: String? = null,
)