package service

import model.Profile._
import profile.simple._
import model.Plugin

trait PluginService {

  def getPlugins()(implicit s: Session): List[Plugin] = Plugins.sortBy(_.pluginId).list

  def registerPlugin(plugin: Plugin)(implicit s: Session): Unit = Plugins.insert(plugin)

  def updatePlugin(plugin: Plugin)(implicit s: Session): Unit = Plugins.update(plugin)

  def deletePlugin(pluginId: String)(implicit s: Session): Unit = Plugins.filter(_.pluginId === pluginId.bind).delete

  def getPlugin(pluginId: String): Option[Plugin] = Plugins.filter(_.pluginId === pluginId.bind).firstOption

}
