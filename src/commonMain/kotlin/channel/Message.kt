package cloud.drakon.tempest.channel

enum class Flags(val VALUE: Byte) {
    /** Do not include any embeds when serializing this message. */
    SUPPRESS_EMBEDS(1 shl 2),

    /** This message is only visible to the user who invoked the Interaction. */
    EPHEMERAL(1 shl 6),
}