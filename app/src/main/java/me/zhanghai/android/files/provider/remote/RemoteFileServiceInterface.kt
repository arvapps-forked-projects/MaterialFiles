/*
 * Copyright (c) 2019 Hai Zhang <dreaming.in.code.zh@gmail.com>
 * All Rights Reserved.
 */

package me.zhanghai.android.files.provider.remote

import me.zhanghai.android.files.provider.FileSystemProviders

open class RemoteFileServiceInterface : IRemoteFileService.Stub() {
    override fun getRemoteFileSystemProviderInterface(scheme: String): IRemoteFileSystemProvider =
        RemoteFileSystemProviderInterface(FileSystemProviders[scheme])

    override fun getRemoteFileSystemInterface(fileSystem: ParcelableObject): IRemoteFileSystem =
        RemoteFileSystemInterface(fileSystem.value())

    override fun getRemotePosixFileStoreInterface(
        fileStore: ParcelableObject
    ): IRemotePosixFileStore = RemotePosixFileStoreInterface(fileStore.value())

    override fun getRemotePosixFileAttributeViewInterface(
        attributeView: ParcelableObject
    ): IRemotePosixFileAttributeView =
        RemotePosixFileAttributeViewInterface(attributeView.value())
}
