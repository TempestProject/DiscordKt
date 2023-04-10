package cloud.drakon.ktdiscord.channel.message

import cloud.drakon.ktdiscord.application.Application
import cloud.drakon.ktdiscord.channel.Attachment
import cloud.drakon.ktdiscord.channel.Channel
import cloud.drakon.ktdiscord.channel.ChannelMention
import cloud.drakon.ktdiscord.channel.Reaction
import cloud.drakon.ktdiscord.channel.embed.Embed
import cloud.drakon.ktdiscord.components.Component
import cloud.drakon.ktdiscord.interaction.MessageInteraction
import cloud.drakon.ktdiscord.permissions.Role
import cloud.drakon.ktdiscord.sticker.Sticker
import cloud.drakon.ktdiscord.sticker.StickerItem
import cloud.drakon.ktdiscord.user.User
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a message sent in a channel within Discord.
 * @property id id of the message
 * @property channelId id of the channel the message was sent in
 * @property author the author of this message. The author object follows the structure of the user object, but is only a valid user in the case where the message is generated by a user or bot user. If the message is generated by a webhook, the author object corresponds to the webhook's id, username, and avatar. You can tell if a message is generated by a webhook by checking for the `webhook_id` on the message object.
 * @property content contents of the message. An app will receive empty values in the content, embeds, attachments, and components fields if they have not configured (or been approved for) the `MESSAGE_CONTENT` privileged intent (`1 << 15`).
 * @property timestamp when this message was sent
 * @property editedTimestamp when this message was edited (or null if never)
 * @property tts whether this was a TTS message
 * @property mentionEveryone whether this message mentions everyone
 * @property mentions users specifically mentioned in the message
 * @property mentionRoles roles specifically mentioned in this message
 * @property mentionChannels channels specifically mentioned in this message. Not all channel mentions in a message will appear in `mention_channels`. Only textual channels that are visible to everyone in a lurkable guild will ever be included. Only crossposted messages (via Channel Following) currently include `mention_channels` at all. If no mentions in the message meet these requirements, this field will not be sent.
 * @property attachments any attached files. An app will receive empty values in the content, embeds, attachments, and components fields if they have not configured (or been approved for) the `MESSAGE_CONTENT` privileged intent (`1 << 15`).
 * @property embeds any embedded content. An app will receive empty values in the content, embeds, attachments, and components fields if they have not configured (or been approved for) the `MESSAGE_CONTENT` privileged intent (`1 << 15`).
 * @property reactions reactions to the message
 * @property nonce used for validating a message was sent
 * @property pinned whether this message is pinned
 * @property webhookId if the message is generated by a webhook, this is the webhook's id
 * @property type type of message
 * @property activity sent with Rich Presence-related chat embeds
 * @property application sent with Rich Presence-related chat embeds
 * @property applicationId if the message is an Interaction or application-owned webhook, this is the id of the application
 * @property messageReference data showing the source of a crosspost, channel follow add, pin, or reply message
 * @property flags message flags combined as a bitfield
 * @property referencedMessage the message associated with the message_reference. This field is only returned for messages with a `type` of `19` (REPLY) or `21` (THREAD_STARTER_MESSAGE). If the message is a reply but the `referenced_message` field is not present, the backend did not attempt to fetch the message that was being replied to, so its state is unknown. If the field exists but is null, the referenced message was deleted.
 * @property interaction sent if the message is a response to an Interaction
 * @property thread the thread that was started from this message, includes thread member object
 * @property components sent if the message contains components like buttons, action rows, or other interactive components. An app will receive empty values in the content, embeds, attachments, and components fields if they have not configured (or been approved for) the `MESSAGE_CONTENT` privileged intent (`1 << 15`).
 * @property stickerItems sent if the message contains stickers
 * @property stickers **Deprecated** the stickers sent with the message
 * @property position A generally increasing integer (there may be gaps or duplicates) that represents the approximate position of the message in a thread, it can be used to estimate the relative position of the message in a thread in company with `total_message_sent` on parent thread
 */
@Serializable class Message(
    val id: String,
    @SerialName("channel_id") val channelId: String,
    val author: User,
    val content: String,
    val timestamp: String,
    @SerialName("edited_timestamp") val editedTimestamp: String?,
    val tts: Boolean,
    @SerialName("mention_everyone") val mentionEveryone: Boolean,
    val mentions: Array<User>,
    @SerialName("mention_roles") val mentionRoles: Array<Role>,
    @SerialName("mention_channels") val mentionChannels: Array<ChannelMention>? = null,
    val attachments: Array<Attachment>,
    val embeds: Array<Embed>,
    val reactions: Array<Reaction>? = null,
    val nonce: String? = null,
    val pinned: Boolean,
    @SerialName("webhook_id") val webhookId: String? = null,
    val type: Byte,
    val activity: MessageActivity? = null,
    val application: Application? = null,
    @SerialName("application_id") val applicationId: String? = null,
    @SerialName("message_reference") val messageReference: MessageReference? = null,
    val flags: Byte,
    @SerialName("referenced_message") val referencedMessage: Message? = null,
    val interaction: MessageInteraction? = null,
    val thread: Channel? = null,
    val components: Array<Component>? = null,
    @SerialName("sticker_items") val stickerItems: Array<StickerItem>? = null,
    @Deprecated(message = "Deprecated") val stickers: Array<Sticker>? = null,
    val position: Int? = null,
)
